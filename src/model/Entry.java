/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author LENOVO
 * @param <T>
 */
public class Entry<T> {
    String key;
    T value;

    public Entry(String key, T value) {
        this.key = key;
        this.value = value;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entry<?> other = (Entry<?>) obj;
        return Objects.equals(this.key, other.key);
    }


    
    
    
}
