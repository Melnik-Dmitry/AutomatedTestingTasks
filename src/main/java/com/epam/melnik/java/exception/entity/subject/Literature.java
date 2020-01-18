/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.subject;

import java.util.Objects;

/**
 * Class describes entity Literature
 *
 * @author Dmitry Melnik
 * @see Object
 * @see EducationSubject
 */
public class Literature extends EducationSubject {

    private LiteratureLang lang;

    public LiteratureLang getLang() {

        return lang;
    }

    public void setLang(LiteratureLang lang) {

        this.lang = lang;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Literature)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Literature that = (Literature) o;
        return getLang() == that.getLang();
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getLang());
    }

    @Override
    public String toString() {

        return "Literature{" + super.toString() + " " +
                "lang=" + lang + "}";
    }
}
