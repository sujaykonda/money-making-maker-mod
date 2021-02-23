package me._xgqd.moneymakingmaker.hypixel.auctions;

import me._xgqd.moneymakingmaker.SortedList;

import java.util.*;

public class ItemAuctionData extends AbstractList<Auction>  {

    SortedList<Auction> data;

    public ItemAuctionData(){
        data = new SortedList<Auction>(new Comparator<Auction>() {
            @Override
            public int compare(Auction d1, Auction d2) {
                return d1.getPrice() - d2.getPrice();
            }
        });
    }

    @Override
    public Auction get(int index) {
        return data.get(index);
    }

    @Override
    public int size() {
        return data.size();
    }

    public boolean add(Auction a){
        data.add(a);
        return true;
    }

    public int getPrice(int i){
        return data.get(i).getPrice();
    }

}
