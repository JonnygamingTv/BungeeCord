package net.md_5.bungee.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.protocol.AbstractPacketHandler;
import net.md_5.bungee.protocol.DefinedPacket;
import net.md_5.bungee.protocol.ProtocolConstants;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Title extends DefinedPacket
{

    private Action action;

    // TITLE & SUBTITLE
    private BaseComponent text;

    // TIMES
    private int fadeIn;
    private int stay;
    private int fadeOut;

    public Title(Action action)
    {
        this.action = action;
    }

    @Override
    public void read(ByteBuf buf, ProtocolConstants.Direction direction, int protocolVersion)
    {
        if ( protocolVersion >= ProtocolConstants.MINECRAFT_1_17 )
        {
            text = readBaseComponent( buf, protocolVersion );
            return;
        }

        int index = readVarInt( buf );

        // If we're working on 1.10 or lower, increment the value of the index so we pull out the correct value.
        if ( protocolVersion <= ProtocolConstants.MINECRAFT_1_10 && index >= 2 )
        {
            index++;
        }

        action = Action.values()[index];
        switch ( action )
        {
            case TITLE:
            case SUBTITLE:
            case ACTIONBAR:
                text = readBaseComponent( buf, protocolVersion );
                break;
            case TIMES:
                fadeIn = buf.readInt();
                stay = buf.readInt();
                fadeOut = buf.readInt();
                break;
        }
    }

    @Override
    public void write(ByteBuf buf, ProtocolConstants.Direction direction, int protocolVersion)
    {
        if ( protocolVersion >= ProtocolConstants.MINECRAFT_1_17 )
        {
            writeBaseComponent( text, buf, protocolVersion );
            return;
        }

        int index = action.ordinal();

        // If we're working on 1.10 or lower, increment the value of the index so we pull out the correct value.
        if ( protocolVersion <= ProtocolConstants.MINECRAFT_1_10 && index >= 2 )
        {
            index--;
        }

        writeVarInt( index, buf );
        switch ( action )
        {
            case TITLE:
            case SUBTITLE:
            case ACTIONBAR:
                writeBaseComponent( text, buf, protocolVersion );
                break;
            case TIMES:
                buf.writeInt( fadeIn );
                buf.writeInt( stay );
                buf.writeInt( fadeOut );
                break;
        }
    }

    @Override
    public void handle(AbstractPacketHandler handler) throws Exception
    {
        handler.handle( this );
    }

    public static enum Action
    {

        TITLE,
        SUBTITLE,
        ACTIONBAR,
        TIMES,
        CLEAR,
        RESET
    }
}
