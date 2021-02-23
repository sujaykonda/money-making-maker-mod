package me._xgqd.moneymakingmaker;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Comparator;

public class SortedList<E> extends AbstractList<E> {
    ArrayList<E> list;
    Comparator<E> comparator;
    public SortedList(Comparator<E> comparator){
        list = new ArrayList<E>();
        this.comparator = comparator;
    }
    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    public boolean add(E e){
        add(e, -1, list.size());
        return true;
    }

    private void add(E e, int min, int max){

        int mid = (min + max)/2;

        if((min + 1) == max){
            list.add(max, e);
            return;
        }

        if(comparator.compare(e, list.get(mid)) < 0){
            add(e, min, mid);
        }else{
            add(e, mid, max);
        }
    }
}
