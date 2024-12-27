package me._xgqd.moneymakingmaker.hypixel.auctions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

import com.google.gson.JsonObject;

import me._xgqd.moneymakingmaker.hypixel.Request;

public class Auction {
    String id;

    int price;
    boolean bin;

    String auctioneer;

    long start;
    long end;

    private static final int BUFFER_SIZE = 64;

    public Auction(JsonObject raw_data) throws IOException {
        bin = raw_data.has("bin") && raw_data.get("bin").getAsBoolean();
        price = raw_data.get("highest_bid_amount").getAsInt() == 0 ? raw_data.get("starting_bid").getAsInt()
                : raw_data.get("highest_bid_amount").getAsInt();
        char[] item_bytes = decodeBytes(raw_data.get("item_bytes").getAsString());
        String field = "";
        int i = item_bytes.length - 1;
        while (true) {
            if (item_bytes[i] < ' ') {
                if (field.equals("di")) {
                    break;
                }
                field = "";
            } else {
                field += item_bytes[i];
            }
            i--;
        }
        id = "";
        i += 5;
        char c;
        while ((c = item_bytes[i]) >= ' ') {
            id += c;
            i++;
        }

        auctioneer = raw_data.get("auctioneer").getAsString();

        start = raw_data.get("start").getAsLong();
        end = raw_data.get("end").getAsLong();
    }

    public char[] decodeBytes(String raw) throws IOException {

        byte[] compressed_bytes = Base64.getDecoder().decode(raw);
        ByteArrayInputStream byteArrayStream = new ByteArrayInputStream(compressed_bytes);
        GZIPInputStream gzipStream = new GZIPInputStream(byteArrayStream, BUFFER_SIZE);
        StringBuilder string = new StringBuilder();
        byte[] data = new byte[BUFFER_SIZE];
        int bytesRead;
        while ((bytesRead = gzipStream.read(data)) != -1) {
            string.append(new String(data, 0, bytesRead));
        }
        gzipStream.close();
        byteArrayStream.close();
        return string.toString().toCharArray();
    }

    public String getId() {
        return id;
    }

    public boolean isBin() {
        return bin;
    }

    public int getPrice() {
        return price;
    }

    public String getAuctioneerUUID() {
        return auctioneer;
    }

    public long getEnd() {
        return end;
    }

    public long getStart() {
        return start;
    }

    public long getTimeLeft() {
        return end - System.currentTimeMillis();
    }

    public String getAuctioneerName() throws IOException {
        JsonObject profile = Request
                .readJsonFromUrl("https://sessionserver.mojang.com/session/minecraft/profile/" + auctioneer)
                .getAsJsonObject();

        // Extract the "name" field directly from the response
        return profile.get("name").getAsString();
    }

    public String toString() {
        return String.valueOf(getPrice());
    }
}
