<<<<<<< HEAD:protocol/src/main/java/net/md_5/bungee/protocol/PlayerPublicKey.java
package net.md_5.bungee.protocol;

import lombok.Data;

@Data
public class PlayerPublicKey
{

    private final long expiry;
    private final byte[] key;
    private final byte[] signature;
}
=======
package net.md_5.bungee.protocol.data;

import lombok.Data;

@Data
public class PlayerPublicKey
{

    private final long expiry;
    private final byte[] key;
    private final byte[] signature;
}
>>>>>>> 83ba0ec42dd86d3399eb0c35a0f45c45ea7a9fed:protocol/src/main/java/net/md_5/bungee/protocol/data/PlayerPublicKey.java
