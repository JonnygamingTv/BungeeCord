<<<<<<< HEAD:protocol/src/main/java/net/md_5/bungee/protocol/Property.java
package net.md_5.bungee.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Property
{

    private String name;
    private String value;
    private String signature;

    public Property(String name, String value)
    {
        this( name, value, null );
    }
}
=======
package net.md_5.bungee.protocol.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Property
{

    private String name;
    private String value;
    private String signature;

    public Property(String name, String value)
    {
        this( name, value, null );
    }
}
>>>>>>> 83ba0ec42dd86d3399eb0c35a0f45c45ea7a9fed:protocol/src/main/java/net/md_5/bungee/protocol/data/Property.java
