<<<<<<< HEAD:protocol/src/main/java/net/md_5/bungee/protocol/NumberFormat.java
package net.md_5.bungee.protocol;

import lombok.Data;

@Data
public class NumberFormat
{

    private final Type type;
    private final Object value;

    public enum Type
    {
        BLANK,
        STYLED,
        FIXED;
    }
}
=======
package net.md_5.bungee.protocol.data;

import lombok.Data;

@Data
public class NumberFormat
{

    private final Type type;
    private final Object value;

    public enum Type
    {
        BLANK,
        STYLED,
        FIXED;
    }
}
>>>>>>> 83ba0ec42dd86d3399eb0c35a0f45c45ea7a9fed:protocol/src/main/java/net/md_5/bungee/protocol/data/NumberFormat.java
