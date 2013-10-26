package com.googlecode.fahview.v6project.utilities;

/*
 * #%L
 * This file is part of FAHView-v6project.
 * %%
 * Copyright (C) 2011 - 2013 Michael Thomas <mikepthomas@outlook.com>
 * %%
 * FAHView is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * %
 * FAHView is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * %
 * You should have received a copy of the GNU General Public License
 * along with FAHView.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Class to extract data from Folding@home client queue files.
 *
 * @author <a href="mailto:mikepthomas@outlook.com">Michael Thomas</a>
 * @version $Id: $Id
 */
public class QueueReader {
    private RandomAccessFile file;

    /**
     * <p>Constructor for QueueReader.</p>
     *
     * @param fileName a {@link java.lang.String} object.
     */
    public QueueReader(String fileName) {
        try {
            file = new RandomAccessFile(fileName, "r");
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " Not Found");
        }
    }

    /**
     * get bytes from the queue file at the specified position
     *
     * @param position position in file to seek to
     * @param length length in bytes to read
     * @return byte[] raw bytes from file
     */
    public byte[] read(int position, int length) {
        byte[] buf = new byte[length];
        try {
            file.seek(position);
            file.read(buf);
        } catch (IOException ex) {
            System.err.println("Failed to read " + length + "bytes from position " + position);
        }
        return buf;
    }
    
    /**
     * Read a Big Endian Unsigned Integer from the queue file
     *
     * @see <a href="http://darksleep.com/player/JavaAndUnsignedTypes.html">JavaAndUnsignedTypes</a>
     * @param position position in file to seek to
     * @param length length in bytes to read
     * @return long Big Endian Unsigned Integer
     */
    public long readBEUInt(int position, int length) {
        byte[] buf = this.read(position, length);
        
        int index = 0;
        int firstByte = (0xFF & ((int)buf[index]));
        int secondByte = (0xFF & ((int)buf[index+1]));
        int thirdByte = (0xFF & ((int)buf[index+2]));
        int fourthByte = (0xFF & ((int)buf[index+3]));
	return ((long) (firstByte << 24
	                | secondByte << 16
                        | thirdByte << 8
                        | fourthByte))
                       & 0xFFFFFFFFL;
    }
    
    /**
     * Read a Little Endian Unsigned Integer from the queue file
     *
     * @param position position in file to seek to
     * @param length length in bytes to read
     * @return long Little Endian Unsigned Interger
     */
    public long readLEUInt(int position, int length) {
        return ByteSwapper.swap((int) readBEUInt(position, length));
    }
    
    /**
     * Read a Big Endian Unsigned Short from the queue file
     *
     * @see <a href="http://darksleep.com/player/JavaAndUnsignedTypes.html">JavaAndUnsignedTypes</a>
     * @param position position in file to seek to
     * @param length length in bytes to read
     * @return int Big Endian Unsigned Short
     */
    public int readBEUShort(int position, int length) {
        byte[] buf = this.read(position, length);
        
        int index = 0;
        int firstByte = (0xFF & ((int)buf[index]));
        int secondByte = (0xFF & ((int)buf[index+1]));
	return (char) (firstByte << 8 | secondByte);
    }
    
    /**
     * Read a Little Endian Unsigned Short from the queue file
     *
     * @param position position in file to seek to
     * @param length length in bytes to read
     * @return long Little Endian Unsigned Short
     */
    public int readLEUShort(int position, int length) {
        return ByteSwapper.swap((short) readBEUShort(position, length));
    }
    
    /**
     * Read an IP Address from the queue file
     *
     * @param position position in file to seek to
     * @return byte[] IP address in network order
     */
    public byte[] readIP(int position) {
        byte[] buf = this.read(position, 4);
        byte[] ip = new byte[buf.length];
        ip[0] = buf[3];
        ip[1] = buf[2];
        ip[2] = buf[1];
        ip[3] = buf[0];
        return ip;
    }
    
    /**
     * Read a String from the queue file
     *
     * @param position position in file to seek to
     * @param length length in bytes to read
     * @return String String of characters from file
     */
    public String readString(int position, int length) {
        byte[] buf = this.read(position, length);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < buf.length; i++) {
            if (buf[i] != 0) {
                char c = (char)buf[i];
                result.append(c);
            }
        }
        return result.toString();
    }
}
