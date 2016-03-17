package com.nt.cryptotool.objects;

import java.io.File;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.Random;

/**
 * Created by Nandan on 3/11/2016.
 * @author Nandan
 * @version 1.0
 * This class represents the key that is used for the rest of the cryptographic system.
 * The key contains 2 256-bit whitening keys, and one 64-bit S-Box key.
 * The key is then saved by XORing it with a new {@Link java.util.Random}
 *      generated with the binary value of the password as the seed.
 */
public class Key implements Serializable{


    /**
     * Constructor method for a pre-existing key.
     * @param keyFile File object that points to the keyfile
     * @param password The password for the key in string format
     * @see Key
     */
    public Key(File keyFile,String password){
        //TODO Input the keyfile, and convert it to a key object.
    }

    /**
     * Constructor method for a new key.
     * @param password the password that the file will be saved with.
     */
    public Key(String password){

    }

    public BitSet getFirstWhiteningKey(){
        BitSet firstWhiteningKey = new BitSet(256);
        //TODO get actual whitening keys from file
        return firstWhiteningKey;
    }

    public BitSet getLastWhiteningKey(){
        BitSet lastWhiteningKey = new BitSet(256);
        //TODO get actual whitening keys from file
        return lastWhiteningKey;
    }

    public BitSet getSBoxKeys(){
        BitSet sboxKeys = new BitSet(64);
        //TODO get sbox keys from actual files
        return sboxKeys;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}