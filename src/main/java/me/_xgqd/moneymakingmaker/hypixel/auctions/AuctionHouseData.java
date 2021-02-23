package me._xgqd.moneymakingmaker.hypixel.auctions;

import java.util.HashMap;

public class AuctionHouseData {
    public HashMap<String, ItemAuctionData> binData;
    public HashMap<String, ItemAuctionData> auctionData;
    public AuctionHouseData(){
        binData = new HashMap<String, ItemAuctionData>();
        auctionData = new HashMap<String, ItemAuctionData>();
    }
}
