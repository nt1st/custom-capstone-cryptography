package com.nt.cryptotool.objects;

import com.nt.cryptotool.MainApp;
import com.nt.cryptotool.utils.Converter;

import java.io.File;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.BitSet;
import java.security.SecureRandom;

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

    private BitSet firstWhite;
    private BitSet lastWhite;
    private BitSet sBox;
    private BitSet keySecurity;
    private SecureRandom sRandom;
    private Converter converter = new Converter();

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
        firstWhite = new BitSet(256);
        lastWhite = new BitSet(256);
        sBox = new BitSet(64);
        keySecurity = new BitSet();
        sRandom = new SecureRandom();
        //Generate XOR Key
        sRandom.setSeed(converter.stringToBigInt(password).longValue());
        keySecurity = converter.bitsFromRandom(sRandom,576);
        //Reset SecureRandom
        sRandom.setSeed(sRandom.generateSeed(512));
        //Generate firstWhite
        firstWhite = converter.bitsFromRandom(sRandom,256);
        //Generate lastWhite
        lastWhite = converter.bitsFromRandom(sRandom,256);
        //Generate SBox
        sBox = converter.bitsFromRandom(sRandom,64);
    }

    public BitSet getFirstWhiteningKey(){
        return firstWhite;
    }

    public BitSet getLastWhiteningKey(){
        return lastWhite;
    }

    public BitSet getSBoxKeys(){
        return sBox;
    }

    public BitSet getBitsToSave(){
        BitSet finalBits = new BitSet(576);
        for (int i = 0; i < 64; i++) {
            finalBits.set(i,sBox.get(i));
        }
        for (int i = 0; i <256 ; i++) {
            finalBits.set(64+i,firstWhite.get(i));
        }
        for (int i = 0; i <256 ; i++) {
            finalBits.set(320+i,lastWhite.get(i));
        }
        finalBits.xor(keySecurity);
        return finalBits;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
