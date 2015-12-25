package tech.spencercolton.tasp.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import tech.spencercolton.tasp.Util.Config;
import tech.spencercolton.tasp.Util.M;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@link TASPCommand} object containing the runtime information for the {@code killall} command.
 *
 * <table summary="Properties">
 *     <tr>
 *         <th style="font-weight:bold;">Property</th>
 *         <th style="font-weight:bold;">Value</th>
 *     </tr>
 *     <tr>
 *         <td>
 *             Name
 *         </td>
 *         <td>
 *             {@value name}
 *         </td>
 *     </tr>
 *     <tr>
 *         <td>
 *             Permission
 *         </td>
 *         <td>
 *             {@code tasp.killall}
 *         </td>
 *     </tr>
 *     <tr>
 *         <td>
 *             Syntax
 *         </td>
 *         <td>
 *             {@value syntax}
 *         </td>
 *     </tr>
 *     <tr>
 *         <td>
 *             Console Syntax
 *         </td>
 *         <td>
 *             {@value consoleSyntax}
 *         </td>
 *     </tr>
 * </table>
 */
public class KillallCmd extends TASPCommand {

    /**
     * String containing the command's name.
     */
    public static final String name = "killall";

    /**
     * String containing the command's syntax.
     */
    private static final String syntax = "/killall [entity] [radius] OR /killall [entity]";

    /**
     * String containing the command's console syntax.
     */
    private static final String consoleSyntax = "/killall [entity] [world]";

    private static final String permission = "tasp.killall";

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(CommandSender sender, String... argsg) {
        List<String> args = Command.processQuotedArguments(argsg);

        List<EntityType> banList = new ArrayList<>();
        banList.add(EntityType.ARMOR_STAND);
        banList.add(EntityType.ARROW);
        banList.add(EntityType.BOAT);
        banList.add(EntityType.COMPLEX_PART);
        banList.add(EntityType.DROPPED_ITEM);
        banList.add(EntityType.EGG);
        banList.add(EntityType.ENDER_CRYSTAL);
        banList.add(EntityType.ENDER_PEARL);
        banList.add(EntityType.ENDER_SIGNAL);
        banList.add(EntityType.EXPERIENCE_ORB);
        banList.add(EntityType.FALLING_BLOCK);
        banList.add(EntityType.FIREBALL);
        banList.add(EntityType.FIREWORK);
        banList.add(EntityType.FISHING_HOOK);
        banList.add(EntityType.ITEM_FRAME);
        banList.add(EntityType.LEASH_HITCH);
        banList.add(EntityType.LIGHTNING);
        banList.add(EntityType.MINECART);
        banList.add(EntityType.MINECART_CHEST);
        banList.add(EntityType.MINECART_COMMAND);
        banList.add(EntityType.MINECART_FURNACE);
        banList.add(EntityType.MINECART_HOPPER);
        banList.add(EntityType.MINECART_MOB_SPAWNER);
        banList.add(EntityType.MINECART_TNT);
        banList.add(EntityType.PAINTING);
        banList.add(EntityType.PLAYER);
        banList.add(EntityType.PRIMED_TNT);
        banList.add(EntityType.SMALL_FIREBALL);
        banList.add(EntityType.SNOWBALL);
        banList.add(EntityType.SPLASH_POTION);
        banList.add(EntityType.THROWN_EXP_BOTTLE);
        banList.add(EntityType.UNKNOWN);
        banList.add(EntityType.WEATHER);
        banList.add(EntityType.WITHER_SKULL);

        List<EntityType> emonster = new ArrayList<>();
        emonster.add(EntityType.BAT);
        emonster.add(EntityType.CAVE_SPIDER);
        emonster.add(EntityType.CREEPER);
        emonster.add(EntityType.ENDER_DRAGON);
        emonster.add(EntityType.ENDERMAN);
        emonster.add(EntityType.ENDERMITE);
        emonster.add(EntityType.GHAST);
        emonster.add(EntityType.GIANT);
        emonster.add(EntityType.GUARDIAN);
        emonster.add(EntityType.MAGMA_CUBE);
        emonster.add(EntityType.PIG_ZOMBIE);
        emonster.add(EntityType.SILVERFISH);
        emonster.add(EntityType.SKELETON);
        emonster.add(EntityType.SLIME);
        emonster.add(EntityType.SPIDER);
        emonster.add(EntityType.WITCH);
        emonster.add(EntityType.WITHER);
        emonster.add(EntityType.ZOMBIE);

        List<EntityType> eanimal = new ArrayList<>();
        eanimal.add(EntityType.CHICKEN);
        eanimal.add(EntityType.COW);
        eanimal.add(EntityType.HORSE);
        eanimal.add(EntityType.IRON_GOLEM);
        eanimal.add(EntityType.MUSHROOM_COW);
        eanimal.add(EntityType.OCELOT);
        eanimal.add(EntityType.PIG);
        eanimal.add(EntityType.RABBIT);
        eanimal.add(EntityType.SHEEP);
        eanimal.add(EntityType.SNOWMAN);
        eanimal.add(EntityType.VILLAGER);
        eanimal.add(EntityType.WOLF);

        List<EntityType> ets = new ArrayList<>();
        ets.add(EntityType.BAT);
        ets.add(EntityType.BLAZE);
        ets.add(EntityType.CAVE_SPIDER);
        ets.add(EntityType.CHICKEN);
        ets.add(EntityType.COW);
        ets.add(EntityType.CREEPER);
        ets.add(EntityType.ENDER_DRAGON);
        ets.add(EntityType.ENDERMAN);
        ets.add(EntityType.ENDERMITE);
        ets.add(EntityType.GHAST);
        ets.add(EntityType.GIANT);
        ets.add(EntityType.GUARDIAN);
        ets.add(EntityType.HORSE);
        ets.add(EntityType.IRON_GOLEM);
        ets.add(EntityType.MAGMA_CUBE);
        ets.add(EntityType.MUSHROOM_COW);
        ets.add(EntityType.OCELOT);
        ets.add(EntityType.PIG);
        ets.add(EntityType.PIG_ZOMBIE);
        ets.add(EntityType.RABBIT);
        ets.add(EntityType.SHEEP);
        ets.add(EntityType.SILVERFISH);
        ets.add(EntityType.SKELETON);
        ets.add(EntityType.SLIME);
        ets.add(EntityType.SNOWMAN);
        ets.add(EntityType.SPIDER);
        ets.add(EntityType.SQUID);
        ets.add(EntityType.VILLAGER);
        ets.add(EntityType.WITCH);
        ets.add(EntityType.WITHER);
        ets.add(EntityType.WOLF);
        ets.add(EntityType.ZOMBIE);

        List<String> pets = new ArrayList<>();
        pets.add("all");
        pets.add("monster");
        pets.add("animal");

        pets.addAll(ets.stream().map(et -> et.toString().toLowerCase()).collect(Collectors.toList()));

        if(sender instanceof Player) {
            switch(args.size()){
                case 0:
                    World w = ((Entity) sender).getWorld();
                    int count = 0;

                    List<Entity> es = w.getEntities();
                    for(Entity e : es) {
                        if(ets.contains(e.getType()) && !banList.contains(e.getType())) {
                            e.remove();
                            count++;
                        }
                    }

                    this.sendCountMessage(sender, count, w.getName());
                    return;
                case 1:
                    World w2 = ((Entity) sender).getWorld();
                    int cxt = 0;

                    if(!pets.contains(args.get(0).toLowerCase())) {
                        Command.sendSyntaxError(sender, this);
                        return;
                    } else {
                        List<Entity> eties = w2.getEntities();

                        for(Entity ex: eties) {
                            if(banList.contains(ex.getType()))
                                continue;
                            if(args.get(0).equalsIgnoreCase("all")) {
                                ex.remove();
                                cxt++;
                            } else if(args.get(0).equalsIgnoreCase("monster")) {
                                if (emonster.contains(ex.getType())) {
                                    ex.remove();
                                    cxt++;
                                }
                            } else if(args.get(0).equalsIgnoreCase("animal")) {
                                if(eanimal.contains(ex.getType())) {
                                    ex.remove();
                                    cxt++;
                                }
                            } else if(ex.getType().toString().equalsIgnoreCase(args.get(0))) {
                                ex.remove();
                                cxt++;
                            }
                        }
                        this.sendCountMessage(sender, cxt, w2.getName());
                    }
                    return;
                case 2:
                    int a;
                    try {
                        a = Integer.parseInt(args.get(1));
                        String ET = args.get(0);

                        World w3 = ((Entity) sender).getWorld();

                        List<String> valid = new ArrayList<>();
                        valid.add("all");
                        valid.add("monster");
                        valid.add("animal");

                        for(EntityType g: EntityType.values()) {
                            valid.add(g.toString());
                        }

                        int czt = 0;

                        List<Entity> eties = w3.getEntities();

                        if(valid.contains(ET)) {
                            for(Entity ex: eties) {
                                if(banList.contains(ex.getType()))
                                    continue;
                                if(ex.getLocation().distance(((Entity) sender).getLocation()) > a)
                                    continue;
                                if(args.get(0).equalsIgnoreCase("all")) {
                                    ex.remove();
                                    czt++;
                                } else if(args.get(0).equalsIgnoreCase("monster")) {
                                    if(emonster.contains(ex.getType())) {
                                        ex.remove();
                                        czt++;
                                    }
                                } else if(args.get(0).equalsIgnoreCase("animal")) {
                                    if(eanimal.contains(ex.getType())) {
                                        ex.remove();
                                        czt++;
                                    }
                                } else if(ex.getType().toString().equalsIgnoreCase(args.get(0))) {
                                    ex.remove();
                                    czt++;
                                }
                            }
                        } else {
                            Command.sendSyntaxError(sender, this);
                            return;
                        }
                        this.sendCountMessage(sender, czt, w3.getName());
                    } catch(NumberFormatException e) {
                        Command.sendSyntaxError(sender, this);
                    }
            }

        } else if (sender instanceof ConsoleCommandSender) {
            switch(args.size()) {
                case 0:
                    World w = Bukkit.getWorlds().get(0);
                    int count = 0;

                    for(Entity g : w.getEntities()) {
                        if(!banList.contains(g.getType())) {
                            g.remove();
                            count++;
                        }
                    }
                    this.sendCountMessage(sender, count, w.getName());
                    return;
                case 1:
                    int ccx = 0;

                    World w2 = Bukkit.getWorlds().get(0);

                    if(!pets.contains(args.get(0))) {
                        Command.sendConsoleSyntaxError((ConsoleCommandSender)sender, this);
                    }


                    for(Entity x : w2.getEntities()) {
                        switch (args.get(0)) {
                            case "all":
                                if (!banList.contains(x.getType())) {
                                    x.remove();
                                    ccx++;
                                }
                                break;
                            case "monster":
                                if (!banList.contains(x.getType()) && emonster.contains(x.getType())) {
                                    x.remove();
                                    ccx++;
                                }
                                break;
                            case "animal":
                                if (!banList.contains(x.getType()) && eanimal.contains(x.getType())) {
                                    x.remove();
                                    ccx++;
                                }
                                break;
                            default:
                                if (x.getType().toString().equalsIgnoreCase(args.get(0)) && !banList.contains(x.getType())) {
                                    x.remove();
                                    ccx++;
                                }
                                break;
                        }
                    }

                    this.sendCountMessage(sender, ccx, w2.getName());

                    return;
                case 2:
                    World w3 = Bukkit.getWorld(args.get(1));

                    int ccz = 0;

                    if(w3 == null) {
                        sender.sendMessage(Config.err() + "World \"" + args.get(1) + "\" does not seem to exist.");
                        return;
                    }

                    if(!pets.contains(args.get(0))) {
                        Command.sendConsoleSyntaxError((ConsoleCommandSender)sender, this);
                    }

                    for(Entity y : w3.getEntities()) {
                        switch(args.get(0)) {
                            case "all":
                                if(!banList.contains(y.getType())) {
                                    y.remove();
                                    ccz++;
                                }
                                break;
                            case "monster":
                                if(!banList.contains(y.getType()) && emonster.contains(y.getType())) {
                                    y.remove();
                                    ccz++;
                                }
                                break;
                            case "animal":
                                if(!banList.contains(y.getType()) && eanimal.contains(y.getType())) {
                                    y.remove();
                                    ccz++;
                                }
                                break;
                            default:
                                if(y.getType().toString().equalsIgnoreCase(args.get(0)) && !banList.contains(y.getType())) {
                                    y.remove();
                                    ccz++;
                                }
                                break;
                        }
                    }

                    this.sendCountMessage(sender, ccz, w3.getName());
            }
        }
    }

    /**
     * Method that sends a message regarding the number of entities killed via this command.
     *
     * @param sender The person to whom the message will be sent.
     * @param count The number of entities killed.
     * @param world The name of the world in which the entities were killed.
     */
    private void sendCountMessage(CommandSender sender, int count, String world) {
        if(Command.messageEnabled(this, false))
            sender.sendMessage(M.m("command-message-text.killall", Integer.toString(count), world));
    }

    @Override
    public String getSyntax() {
        return syntax;
    }

    @Override
    public String getConsoleSyntax() {
        return consoleSyntax;
    }

    @Override
    public String getPermission() {
        return permission;
    }

    @Override
    public String getName() {
        return name;
    }

}
