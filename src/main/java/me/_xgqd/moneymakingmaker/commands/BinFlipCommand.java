package me._xgqd.moneymakingmaker.commands;

import java.io.IOException;
import java.util.Comparator;
import java.util.function.BiConsumer;

import me._xgqd.moneymakingmaker.Config;
import me._xgqd.moneymakingmaker.Main;
import me._xgqd.moneymakingmaker.SortedList;
import me._xgqd.moneymakingmaker.hypixel.auctions.AuctionHouseData;
import me._xgqd.moneymakingmaker.hypixel.auctions.ItemAuctionData;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;

public class BinFlipCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "binflip";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "command.binflip.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    private static class FlipData {
        String itemId;
        int profit;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        final ICommandSender s = sender;
        if (args.length >= 1) {
            final int budget = Integer.parseInt(args[0]);
            Thread t = new Thread() {
                public void run() {
                    long start = System.currentTimeMillis();
                    try {
                        AuctionHouseData data = Main.hypixel.getAuctionHouseData();
                        final SortedList<FlipData> bestFlips = new SortedList<FlipData>(new Comparator<FlipData>() {
                            @Override
                            public int compare(FlipData o1, FlipData o2) {
                                return o2.profit - o1.profit;
                            }
                        });
                        data.binData.forEach(new BiConsumer<String, ItemAuctionData>() {
                            @Override
                            public void accept(String s, ItemAuctionData auctions) {
                                if (auctions.size() >= 20 && auctions.getPrice(0) <= budget) {
                                    FlipData flip = new FlipData();
                                    flip.itemId = s;
                                    flip.profit = auctions.getPrice(1) - auctions.getPrice(0);
                                    bestFlips.add(flip);
                                }
                            }
                        });
                        for (int i = 0; i < 7; i++) {
                            String auctioneer_name = data.binData.get(bestFlips.get(i).itemId).get(0)
                                    .getAuctioneerName();
                            System.out.println(data.binData.get(bestFlips.get(i).itemId).get(0).getAuctioneerUUID());
                            String reply = "Item: " + bestFlips.get(i).itemId + "\n§bProfit§r: §a"
                                    + bestFlips.get(i).profit;
                            if (Config.propToMacroState(Config.getMacroState()).equals(Config.MacroState.TYPE_IN)) {
                                reply += "\nAuctioneer: " + auctioneer_name;
                            }

                            ChatComponentText text = new ChatComponentText(reply);
                            ChatStyle style = new ChatStyle();
                            String ah_cmd = "/ah " + auctioneer_name;
                            if (Config.propToMacroState(Config.getMacroState()).equals(Config.MacroState.COPY_PASTE)) {
                                style.setChatClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, ah_cmd));
                            } else if (Config.propToMacroState(Config.getMacroState()).equals(Config.MacroState.AUTO)) {
                                style.setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ah_cmd));
                            }
                            style.setChatHoverEvent(
                                    new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(ah_cmd)));
                            text.setChatStyle(style);
                            s.addChatMessage(text);
                        }
                    } catch (IOException e) {
                        s.addChatMessage(new ChatComponentText("§cErrored"));
                    }
                }
            };
            t.start();
            s.addChatMessage(new ChatComponentText("§aStarted Processing Auctions"));
        }
    }
}
