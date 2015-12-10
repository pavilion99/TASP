package tech.spencercolton.tasp.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tech.spencercolton.tasp.Entity.Person;

/**
 * Main listener class for player login events.
 *
 * @author Spencer Colton
 * @since 0.0.1-001
 */
public class LoginListener implements Listener {

    /**
     * Waits for a player to join, then creates a {@link Person} object for him or her.
     *
     * @param e The event parameter, supplied by the server.
     */
    @EventHandler
    public void onEvent(PlayerJoinEvent e) {
        new Person(e.getPlayer());
    }

}