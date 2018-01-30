package com.arvindve.heaps;
import java.io.*;
import java.util.*;

/**
 * A CompositeKey is:
 * - composed of multiple Objects
 * - intended for use as a key in a Map
 *
 * The contained Objects and their order uniquely define a CompositeKey.
 *
 * Implement CompositeKey
 */
class CompositeKey {
  
  Object[] objects;

  public CompositeKey(Object... objects) {
    // TODO implement
    this.objects = objects;
  }


  @Override
  public int hashCode() {
    int sum = 0;
    for (Object o : this.objects) {
        sum += o.hashCode();
    }

    return sum;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof CompositeKey)) return false;
    
    if (obj == null) return false;
    
    CompositeKey o = (CompositeKey) obj;
    
    if (this.objects == null && o.objects == null) return true;
    
    if (o.objects == null) return false;

    // compare this.objects with o.objects
    if (this.objects.length != o.objects.length) return false;
    
    for (int i = 0; i < this.objects.length; i++) {
      if (!this.objects[i].equals(o.objects[i])) {
        return false;
      }
    }
    
    return true;
  }
}











//
// These are tests - don't change anything below
//
class Solution {
  public static void main(String[] args) {
    Map<CompositeKey, String> map = new HashMap<>();
    
    CompositeKey keyA = new CompositeKey("A");
    CompositeKey keyB = new CompositeKey("B");
    CompositeKey keyAB = new CompositeKey("A", "B");
    CompositeKey keyBA = new CompositeKey("B", "A");
    
    // enter in 4 new an unique key/values
    map.put(keyA, "value A");
    map.put(keyB, "value B");
    map.put(keyAB, "value AB");
    map.put(keyBA, "value BA");
    

    eq(4, map.size(), "expected size of 4");
    
    
    eq("value A", map.get(keyA), "(A) didn't have the correct value");
    eq("value B", map.get(keyB), "(B) didn't have the correct value");
    eq("value AB", map.get(keyAB), "(AB) didn't have the correct value");
    eq("value BA", map.get(keyBA), "(BA) didn't have the correct value");
    
    CompositeKey keyAClone = new CompositeKey("A");
    eq("value A", map.get(keyAClone), "(A) didn't have the correct value for key clone");
    map.put(keyAClone, "value A updated!");
    eq("value A updated!", map.get(keyA), "(A) wasn't updated with key clone");
    
    
    CompositeKey keyABClone = new CompositeKey("A", "B");
    eq("value AB", map.get(keyABClone), "AB didn't have the correct value");
    map.put(keyABClone, "value AB updated!");
    eq("value AB updated!", map.get(keyAB), "AB should have been updated");
    eq("value BA", map.get(keyBA), "BA should not have been updated");
    
  }
    
public static void eq(Object expected, Object actual, String message) {
    System.out.println("Expected " + expected + ", Actual " + actual);
    if (actual != expected) {
      System.out.println("NO!!  D:");
      System.out.println(message);  
    } else {
      System.out.println("YAY!  =D");
    }
    System.out.println("");
  }
}


//public class CompositeKey {
//
//    public CompositeKey() {
//        // TODO Auto-generated constructor stub
//    }
//
//}
