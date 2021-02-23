package me._xgqd.moneymakingmaker.hypixel;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me._xgqd.moneymakingmaker.hypixel.auctions.Auction;
import me._xgqd.moneymakingmaker.hypixel.auctions.AuctionHouseData;
import me._xgqd.moneymakingmaker.hypixel.auctions.ItemAuctionData;

import java.io.IOException;

public class Hypixel {
    private final String key;
    public Hypixel(String key){
        this.key = key;
    }
    public AuctionHouseData getAuctionHouseData() throws IOException {
        AuctionHouseData data = new AuctionHouseData();
        int totalPages = Request.readJsonFromUrl("https://api.hypixel.net/skyblock/auctions?key=" + key).getAsJsonObject().get("totalPages").getAsInt();
        for(int i = 0; i < totalPages; i++){
            JsonArray auctions = Request.readJsonFromUrl("https://api.hypixel.net/skyblock/auctions?key=" + key + "&&page=" + i).getAsJsonObject().getAsJsonArray("auctions");
            for(JsonElement o : auctions){
                if(!o.getAsJsonObject().get("claimed").getAsBoolean() && o.getAsJsonObject().get("end").getAsLong() > System.currentTimeMillis() + 60000){
                    Auction auction = new Auction(o.getAsJsonObject());

                    if(auction.isBin()){
                        if(!data.binData.containsKey(auction.getId())){
                            data.binData.put(auction.getId(), new ItemAuctionData());
                        }
                        data.binData.get(auction.getId()).add(auction);
                    }else{
                        if(!data.auctionData.containsKey(auction.getId())){
                            data.auctionData.put(auction.getId(), new ItemAuctionData());
                        }
                        data.auctionData.get(auction.getId()).add(auction);
                    }
                }
            }
        }
        return data;
    }
}
