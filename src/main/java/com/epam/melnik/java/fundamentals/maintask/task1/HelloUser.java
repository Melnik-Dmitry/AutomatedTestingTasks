/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.fundamentals.maintask.task1;

import com.epam.melnik.java.util.TaskScanner;

/**
 * Util class says Hello for User
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class HelloUser {

    public static final String ENTER_PHRASE = "Enter your name to log in: ";

    public static final String HELLO_PHRASE = " - Welcome to the system!!!";

    /**
     * The method accepts the user name and welcomes itд
     */
    public static void saidUserHello() {

        System.out.print(ENTER_PHRASE);

        System.out.println(TaskScanner.getName() + HELLO_PHRASE);
    }
}