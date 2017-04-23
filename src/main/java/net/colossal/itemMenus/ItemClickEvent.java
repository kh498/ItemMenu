package net.colossal.itemMenus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

/**
 * An event called when an Item in the {@link net.colossal.itemMenus.ItemMenu} is clicked.
 */
@SuppressWarnings({"WeakerAccess", "SameParameterValue"})
public class ItemClickEvent {
    private final Player player;
    private final ClickType clicktype;
    private final ItemStack stack;
    private final ItemMenu menu;
    private final int clickedSlot;
    private boolean goBack;
    private boolean close;
    private boolean update;

    public ItemClickEvent(final Player player, final ItemStack stack, final ClickType type, final ItemMenu menu,
                          final int clickedSlot) {
        this.player = player;
        this.stack = stack;
        this.clicktype = type;
        this.menu = menu;
        this.clickedSlot = clickedSlot;
    }

    /**
     * Gets the player who clicked.
     *
     * @return The player who clicked.
     */
    public Player getPlayer() {
        return this.player;
    }

    public ClickType getClickType() {
        return this.clicktype;
    }

    public ItemStack getClickedItem() {
        return this.stack;
    }

    public ItemMenu getMenu() { return this.menu; }


    public int getClickedSlot() { return this.clickedSlot; }

    /**
     * Checks if the {@link net.colossal.itemMenus.ItemMenu} will go back to the parent menu.
     *
     * @return True if the {@link net.colossal.itemMenus.ItemMenu} will go back to the parent
     * menu, else false.
     */
    public boolean willGoBack() {
        return this.goBack;
    }

    /**
     * Sets if the {@link net.colossal.itemMenus.ItemMenu} will go back to the parent menu.
     *
     * @param goBack If the {@link net.colossal.itemMenus.ItemMenu} will go back to the
     *               parent menu.
     */
    public void setWillGoBack(final boolean goBack) {
        this.goBack = goBack;
        if (goBack) {
            this.close = false;
            this.update = false;
        }
    }

    /**
     * Checks if the {@link net.colossal.itemMenus.ItemMenu} will close.
     *
     * @return True if the {@link net.colossal.itemMenus.ItemMenu} will close, else false.
     */
    public boolean willClose() {
        return this.close;
    }

    /**
     * Sets if the {@link net.colossal.itemMenus.ItemMenu} will close.
     *
     * @param close If the {@link net.colossal.itemMenus.ItemMenu} will close.
     */
    public void setWillClose(final boolean close) {
        this.close = close;
        if (close) {
            this.goBack = false;
            this.update = false;
        }
    }

    /**
     * Checks if the {@link net.colossal.itemMenus.ItemMenu} will update.
     *
     * @return True if the {@link net.colossal.itemMenus.ItemMenu} will update, else false.
     */
    public boolean willUpdate() {
        return this.update;
    }

    /**
     * Sets if the {@link net.colossal.itemMenus.ItemMenu} will update.
     *
     * @param update If the {@link net.colossal.itemMenus.ItemMenu} will update.
     */
    public void setWillUpdate(final boolean update) {
        this.update = update;
        if (update) {
            this.goBack = false;
            this.close = false;
        }
    }
}
