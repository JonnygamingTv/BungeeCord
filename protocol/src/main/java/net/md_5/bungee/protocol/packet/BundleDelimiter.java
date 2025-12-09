<<<<<<< HEAD:protocol/src/main/java/net/md_5/bungee/protocol/packet/ClientStatus.java
package net.md_5.bungee.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.md_5.bungee.protocol.AbstractPacketHandler;
import net.md_5.bungee.protocol.DefinedPacket;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClientStatus extends DefinedPacket
{

    private byte payload;

    @Override
    public void read(ByteBuf buf)
    {
        payload = buf.readByte();
    }

    @Override
    public void write(ByteBuf buf)
    {
        buf.writeByte( payload );
    }

    @Override
    public void handle(AbstractPacketHandler handler) throws Exception
    {
        handler.handle( this );
    }
}
=======
package net.md_5.bungee.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.md_5.bungee.protocol.AbstractPacketHandler;
import net.md_5.bungee.protocol.DefinedPacket;

@Data
@EqualsAndHashCode(callSuper = false)
public class BundleDelimiter extends DefinedPacket
{

    @Override
    public void read(ByteBuf buf)
    {
    }

    @Override
    public void write(ByteBuf buf)
    {
    }

    @Override
    public void handle(AbstractPacketHandler handler) throws Exception
    {
        handler.handle( this );
    }
}
>>>>>>> 83ba0ec42dd86d3399eb0c35a0f45c45ea7a9fed:protocol/src/main/java/net/md_5/bungee/protocol/packet/BundleDelimiter.java
