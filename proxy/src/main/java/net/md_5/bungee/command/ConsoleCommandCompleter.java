<<<<<<< HEAD
package net.md_5.bungee.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import jline.console.completer.Completer;
import lombok.RequiredArgsConstructor;
import net.md_5.bungee.api.ProxyServer;

@RequiredArgsConstructor
public class ConsoleCommandCompleter implements Completer
{

    private final ProxyServer proxy;

    @Override
    public int complete(String buffer, int cursor, List<CharSequence> candidates)
    {
        int lastSpace = buffer.lastIndexOf( ' ' );
        if ( lastSpace == -1 )
        {
            String lowerCase = buffer.toLowerCase( Locale.ROOT );
            candidates.addAll( proxy.getPluginManager().getCommands().stream()
                    .map( Map.Entry::getKey )
                    .filter( (name) -> name.toLowerCase( Locale.ROOT ).startsWith( lowerCase ) )
                    .collect( Collectors.toList() ) );
        } else
        {
            List<String> suggestions = new ArrayList<>();
            proxy.getPluginManager().dispatchCommand( proxy.getConsole(), buffer, suggestions );
            candidates.addAll( suggestions );
        }

        return ( lastSpace == -1 ) ? cursor - buffer.length() : cursor - ( buffer.length() - lastSpace - 1 );
    }
}
=======
package net.md_5.bungee.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.md_5.bungee.api.ProxyServer;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;

@RequiredArgsConstructor
public class ConsoleCommandCompleter implements Completer
{

    private final ProxyServer proxy;

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates)
    {
        List<String> suggestions;
        String buffer = line.line();

        int lastSpace = buffer.lastIndexOf( ' ' );
        if ( lastSpace == -1 )
        {
            String lowerCase = buffer.toLowerCase( Locale.ROOT );
            suggestions = proxy.getPluginManager().getCommands().stream()
                    .map( Map.Entry::getKey )
                    .filter( (name) -> name.toLowerCase( Locale.ROOT ).startsWith( lowerCase ) )
                    .collect( Collectors.toList() );
        } else
        {
            suggestions = new ArrayList<>();
            proxy.getPluginManager().dispatchCommand( proxy.getConsole(), buffer, suggestions );
        }

        suggestions.stream().map( Candidate::new ).forEach( (candidate) -> candidates.add( candidate ) );
    }
}
>>>>>>> 83ba0ec42dd86d3399eb0c35a0f45c45ea7a9fed
