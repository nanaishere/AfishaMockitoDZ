package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class PurchaseManager {

    private PurchaseItem[] items = new PurchaseItem[0];

    public void add(PurchaseItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] findAll() {
        return posters;
    }

    public Film[] findLast() {
        int resultLength = Math.min(filmsLimit, posters.length);
        PurchaseItem[] result = new PurchaseItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = posters.length - i - 1;
            result[i] = posters[index];
        }
        return poster;
    }
}

    // наивная реализация
    public void removeById(int id) {
        int length = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        // меняем наши элементы
        items = tmp;
    }
}
