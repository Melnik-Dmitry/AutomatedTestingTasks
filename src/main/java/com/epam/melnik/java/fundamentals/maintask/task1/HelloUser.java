/*
 *   Приветствовать любого пользователя при вводе его имени через командную строку.
 */

package com.epam.melnik.java.fundamentals.maintask.task1;

import com.epam.melnik.java.util.TaskScanner;

public class HelloUser {

    public static final String ENTER_PHRASE = "Enter your name to log in: ";

    public static final String HELLO_PHRASE = " - Welcome to the system!!!";

    public static void saidUserHello() {

        System.out.print(ENTER_PHRASE);

        System.out.println(TaskScanner.getName() + HELLO_PHRASE);
    }
}