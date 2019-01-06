package ru.me.utils;

/**
 * Created by Александр on 06.01.2019.
 */
public enum OrderBookErorrs {

    BOOK_IS_ALREADY("Книга уже заказана"),
    NOT_FOUND("Книга не найдена на складе"),
    OK("Книга заказакна успешно");


    private String errorDescrption;
    OrderBookErorrs(String errorDescrption){
        this.errorDescrption = errorDescrption;
    }

    public String getErrorDescrption(){
        return errorDescrption;
    }
}
