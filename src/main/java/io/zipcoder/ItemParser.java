package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {

        String[] strArr = valueToParse.toLowerCase().split("##");
        List<Item> itemLis = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            try {
                itemLis.add(parseSingleItem(strArr[i]));
            } catch (ItemParseException e) {
                e.printStackTrace();
            }
        }


        return itemLis;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {

        String[] arr = singleItem.toLowerCase().split(";");
        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].toLowerCase().split(("[:@^*%#]"))[1];
            }
        } catch (ArrayIndexOutOfBoundsException chuckException) {
            throw new ItemParseException();
        }
        Item item = new Item(arr[0], Double.valueOf(arr[1]), arr[2], arr[3]);


        return item;
    }

}
