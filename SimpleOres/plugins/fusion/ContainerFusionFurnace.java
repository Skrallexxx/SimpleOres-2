package SimpleOres.plugins.fusion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ContainerFusionFurnace extends Container
{
    private TileEntityFusionFurnace furnace;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    /**
     * Adds the inventory and GUI slots to the container. These slots include the inputs, output, catalyst and fuel slots, along with showing your inventory at the bottom of the GUI.
     */
    public ContainerFusionFurnace(InventoryPlayer par1InventoryPlayer, TileEntityFusionFurnace par2TileEntityFurnace)
    {
        this.furnace = par2TileEntityFurnace;
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 33, 35)); //Input1
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 1, 79, 62)); //Fuel
        this.addSlotToContainer(new SlotFusionFurnace(par1InventoryPlayer.player, par2TileEntityFurnace, 2, 79, 34)); //Output
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 3, 126, 34)); //Input2
        this.addSlotToContainer(new Slot(par2TileEntityFurnace, 4, 79, 7)); //Catalyst
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    /**
     * Sends updates to the progress bars (arrows and bubbles).
     */
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.furnace.furnaceCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
            }

            if (this.lastBurnTime != this.furnace.furnaceBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
            }

            if (this.lastItemBurnTime != this.furnace.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.furnace.furnaceCookTime;
        this.lastBurnTime = this.furnace.furnaceBurnTime;
        this.lastItemBurnTime = this.furnace.currentItemBurnTime;
    }

    /**
     * Determines the stage of the progress bar depending on the cooking time. 
     */
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.furnace.furnaceCookTime = par2;
        }

        if (par1 == 1)
        {
            this.furnace.furnaceBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.furnace.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.furnace.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
	@Override public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		Slot slot = (Slot) inventorySlots.get(index);
		if (slot == null || !slot.getHasStack())
			return null;

		ItemStack remained = slot.getStack();
		ItemStack initial = remained.copy();

		if (index == 2 /* output */) {
			if (!mergeItemStack(remained, 3, 39, true))
				return null;

			slot.onSlotChange(remained, initial);
		}
		else if (index >= 5 /* every slots that belong to the player's inventory */) {
			if (TileEntityFusionFurnace.isItemFuel(remained)) {
				if (!mergeItemStack(remained, 1, 2, false))
					return null;
			}
			else if (FusionRecipes.isItemCatalyst(remained)) {
				if (!mergeItemStack(remained, 4, 5, false))
					return null;
			}
			else if (FusionRecipes.isItemInput(remained)) {
				if (!mergeItemStack(remained, 0, 1, false) && !mergeItemStack(remained, 3, 4, false))
					return null;
			}
			else if (index < 32) {
				if (!mergeItemStack(remained, 32, 41, false))
					return null;
			}
			else if (index < 41) {
				if (!mergeItemStack(remained, 5, 32, false))
					return null;
			}
		}
		else
			if (!mergeItemStack(remained, 5, 41, false))
				return null;

		if (remained.stackSize == 0)
			slot.putStack(null);
		else
			slot.onSlotChanged();

		if (remained.stackSize == initial.stackSize)
			return null;
		
		slot.onPickupFromSlot(player, remained);
		
		return initial;
	}
}
