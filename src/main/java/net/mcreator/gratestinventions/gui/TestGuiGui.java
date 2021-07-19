
package net.mcreator.gratestinventions.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;

import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import net.minecraftforge.client.event.InputEvent.ClickInputEvent;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseListener;
import net.java.games.input.Mouse;
import net.minecraft.client.MouseHelper;
import net.minecraftforge.client.event.InputEvent;
import org.jline.terminal.MouseEvent.Button;
import net.minecraftforge.client.event.InputEvent.ClickInputEvent;
import java.awt.dnd.MouseDragGestureRecognizer;
import sun.security.x509.OtherName;
import sun.security.x509.OtherName;
import sun.net.www.content.audio.x_aiff;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

@GratestInventionsModElements.ModElement.Tag
public class TestGuiGui extends GratestInventionsModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	static int grabbedItem;
	static int[][] slotPos = new int[43][2];
	public TestGuiGui(GratestInventionsModElements instance) {
		super(instance, 152);
		//slotPos[1][1] = 5;
		int xShift = 7;
		int yShift = 20;
		int pictureSize = 18;
		int yStep = (int)((pictureSize*Math.sqrt(5))/4 + pictureSize/4);
		int xStep = (int)(pictureSize/2);
		int ii = 0;
		int xPos = 0;
		int yPos = 0;
		for (int slots = 0; slots < slotPos.length; slots++)
		{
			if (slots%17 == 0)
			{
				ii = 0;
				xPos = xShift;
				yPos = yPos + yStep;
			}
			else if ((slots - 9)%17 == 0)
			{
				ii = 0;
				xPos = xShift + xStep;
				yPos = yPos + yStep;
			}
			slotPos[slots][0] = xPos + pictureSize*ii;
			slotPos[slots][1] = yPos;
			ii++;
		}
		System.err.println(slotPos[2][0]);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, GuiWindow::new));
	}

	@SubscribeEvent
	public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(containerType.setRegistryName("test_gui"));
	}
	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private World world;
		private PlayerEntity entity;
		private int x, y, z;
		private IItemHandler internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		private boolean bound = false;
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new ItemStackHandler(0);
			BlockPos pos = null;
			if (extraData != null) {
				pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
			}
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return true;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GuiWindow extends ContainerScreen<GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		public GuiWindow(GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}
		private static final ResourceLocation texture = new ResourceLocation("gratest_inventions:textures/test_gui.png");
		@Override
		public void render(int mouseX, int mouseY, float partialTicks) {
			this.renderBackground();
			super.render(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
			//System.out.println(mouseX);
			//public int xPos;
			//xPos = mousX;
			//System.out.println(InputEvent.getButton());
			MouseData.setMouseX(mouseX);
			MouseData.setMouseY(mouseY);
		}
/*
		@SideOnly(Side.CLIENT)
 		@Override
 		public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
  			boolean pressed = super.mousePressed(mc, mouseX, mouseY);
			if (pressed) {
		    	mc.player.closeScreen();
		    }
		  	return pressed;
		 	}
		}*/
		/*@Override
		protected void handleMouseClick(Slot slotIn, int slotId, int mouseButton, ClickType type) {
			System.out.println(Minecraft);
		}*/

		/*@OnlyIn(Dist.CLIENT)
		protected void mouseClicked(int x, int y, int button) {
			System.out.println("button");
			mouseHe
			//super.mouseClicked(x, y, button);
		}*/

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);
			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			int xPos = 7;
			int yPos = 20;
			int xLength = 18;
			int yLength = 18;
			this.blit(k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

			for (int ii = 0; ii < slotPos.length; ii++)
			{
				xPos = slotPos[ii][0];
				yPos = slotPos[ii][1];
				hover.setState(this.guiLeft, this.guiTop, xPos, yPos, xLength);
				this.blit(hover.xData(), hover.yData(), 0, 0, xLength, yLength, xLength, yLength);
				slotRegistry.slotControl(this.guiLeft, this.guiTop, xPos, yPos, xLength, ii + 1, (int) entity.getPersistentData().getDouble("slot" + (ii + 1)));
				if (true)
				{
					if (slotRegistry.isRemoved() == false)
					{
						if (toTexture.isItemThere() == true)
						{
							this.blit(hover.xData()+1, hover.yData()+1, 0, 0, xLength-2, yLength-2, xLength-2, yLength-2);
						}
					}
					else
					{
						int placeHolder = grabbedItem;
						grabbedItem = (int) entity.getPersistentData().getDouble("slot" + (ii + 1));
						entity.getPersistentData().putDouble("slot" + (ii + 1), placeHolder);
					}
				}
			}
			/*
			xPos = 25;
			hover.setState(this.guiLeft, this.guiTop, xPos, xLength, yPos, yLength);
			this.blit(hover.xData(), hover.yData(), 0, 0, xLength, yLength, xLength, yLength);
			slotRegistry.slotControl(this.guiLeft, this.guiTop, xPos, xLength, yPos, yLength, 2, (int) entity.getPersistentData().getDouble("slot2"));
			if (true)
			{
				if (slotRegistry.isRemoved() == false)
				{
					if (toTexture.isItemThere() == true)
					{
						this.blit(hover.xData()+1, hover.yData()+1, 0, 0, xLength-2, yLength-2, xLength-2, yLength-2);
					}
				}
				else
				{
					int placeHolder = grabbedItem;
					grabbedItem = (int) entity.getPersistentData().getDouble("slot2");
					entity.getPersistentData().putDouble("slot2", placeHolder);
				}
			}
			xPos = 43;
			hover.setState(this.guiLeft, this.guiTop, xPos, xLength, yPos, yLength);
			this.blit(hover.xData(), hover.yData(), 0, 0, xLength, yLength, xLength, yLength);
			slotRegistry.slotControl(this.guiLeft, this.guiTop, xPos, xLength, yPos, yLength, 3, (int) entity.getPersistentData().getDouble("slot3"));
			if (true)
			{
				if (slotRegistry.isRemoved() == false)
				{
					if (toTexture.isItemThere() == true)
					{
						this.blit(hover.xData()+1, hover.yData()+1, 0, 0, xLength-2, yLength-2, xLength-2, yLength-2);
					}
				}
				else
				{
					int placeHolder = grabbedItem;
					grabbedItem = (int) entity.getPersistentData().getDouble("slot3");
					entity.getPersistentData().putDouble("slot3", placeHolder);
				}
			}*/
			if (grabbedItem != 0)
			{
				toTexture.getTexture(grabbedItem);
				if (toTexture.isItemThere() == true)
				{
					this.blit(MouseData.getMouseX()-(xLength-2)/2, MouseData.getMouseY()-(yLength-2)/2, 0, 0, xLength-2, yLength-2, xLength-2, yLength-2);
				}
			}
			if (onButton(this.guiLeft, this.guiTop, 0, 176, 0, 166) == false && MouseData.getMouseClick() == 1)
			{
				entity.getPersistentData().putDouble("slot" + GetEmptySlot(), grabbedItem);
				grabbedItem = 0;
			}
			/*int adamsItemID = slotRegistry.getClickedSlot();
			if (adamsItemID != 0)
			{
				toTexture.getTexture((int) entity.getPersistentData().getDouble("slot" + String.valueOf(adamsItemID)));
				if (toTexture.isItemThere() == true)
				{
					this.blit(MouseData.getMouseX()-(xLength-2)/2, MouseData.getMouseY()-(yLength-2)/2, 0, 0, xLength-2, yLength-2, xLength-2, yLength-2);
				}
			}*/
			/*if (onHexagonButton(this.guiLeft, this.guiTop, xPos, yPos, xLength) == true)
			{
				this.font.drawString( "lohl", MouseData.getMouseX(), MouseData.getMouseX(), -12829636);
			}*/
			slotRegistry.resetToolTip();
			MouseData.resetMouseClick();
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			//System.out.println(key);
			InputMappings.Input mouseKey = InputMappings.getInputByCode(b,c);
			
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			/*if (key == 256) {
				system.out.println("lol!");
			}*/
			return super.keyPressed(key, b, c);
		}
		@Override
		public boolean mouseClicked(double a, double b, int mouseButton) {
			/*System.out.println(p_mouseClicked_1_);
			System.out.println(p_mouseClicked_3_);
			System.out.println(p_mouseClicked_5_);*/
			MouseData.setMouseClick(mouseButton);
			return super.mouseClicked(a,b,mouseButton);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
			this.font.drawString("" + (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return 0;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "tagName")) + "", 30, 9, -12829636);
		}

		@Override
		public void removed() {
			super.removed();
			slotRegistry.resetSlotRegistry();
			entity.getPersistentData().putDouble("slot" + GetEmptySlot(), grabbedItem);
			grabbedItem = 0;
			//System.out.println(entity.getPersistentData().getString("slot1"));
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
		}

		private int GetEmptySlot()
		{
			for (int ii = 0; ii < slotPos.length; ii++)
			{
				if ((int) entity.getPersistentData().getDouble("slot" + (ii + 1)) == 0)
				return ii+1;
			}
			return 0;
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;
		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			//System.out.println(buttonID);
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}
	private static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}

	/*private class clickIdentifier
	{
		double a;
		double b;
		int c;
		private void setClicker(double keyA, double keyB, int keyC) {
			a = keyA;
			b = keyB;
			c = keyC;
			System.out.println(a);
		}
		
		private boolean getClicker() {
			//return ContainerScreen.mouseClicked(a,b,c);
			return true;
		}
	}*/

	private static class MouseData
	{
		static int xPosition;
		static int yPosition;
		static int buttonNum = 0;
		private static void setMouseClick(int num) 
		{
			buttonNum = num + 1;
		}
		private static void setMouseX(int xPos) 
		{
			xPosition = xPos;
		}
		private static void setMouseY(int yPos) 
		{
			yPosition = yPos;
		}
		private static int getMouseX()
		{
			return xPosition;
		}
		private static int getMouseY()
		{
			return yPosition;
		}
		private static int getMouseClick()
		{
			return buttonNum;
		}
		private static void resetMouseClick()
		{
			buttonNum = 0;
		}
	}

	private static class hover
	{
		static int xD;
		static int yD;
		private static void setState(int leftCorner, int upperCorner, int x, int y, int pictureSize)
		{
			xD = leftCorner + x;
			yD = upperCorner + y;
			if (onHexagonButton(leftCorner, upperCorner, x, y, pictureSize) == true)
			{
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("gratest_inventions:textures/slot_hexa_selected.png"));
			}
			else
			{
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("gratest_inventions:textures/slot_hexa.png"));
			}
		}
		private static int xData()
		{
			return xD;
		}
		private static int yData()
		{
			return yD;
		}
	}

	private static boolean onHexagonButton(int leftCorner, int upperCorner, int PosX, int PosY, int l)
	{
		l = l;
		double b = (l*Math.sqrt(5))/4 - 1;
		int x = MouseData.getMouseX() - leftCorner - PosX;
		int y = MouseData.getMouseY() - upperCorner - PosY;
		double x_a = x - l/2;
		double y_a = y - l/4;
		double y_b = y_a - b;

		if ((x >= 0 && x <= l - 1 && y >= 0 && y <= l)&&((y_a >= 0 && y_a <= b)||(y_a < 0 && (Math.abs(x_a) - 2*y_a)/(l - 1) <= 0.5)||(y_b > 0 && (Math.abs(x_a) + 2*y_b)/l <= 0.5)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private static boolean onButton(int leftCorner, int upperCorner, int x, int xSize, int y, int ySize)
	{
		int xPos = MouseData.getMouseX() - leftCorner;
		int yPos = MouseData.getMouseY() - upperCorner;
		if (x + 1 <= xPos && xPos <= x + xSize - 1 && y + 1 <= yPos && yPos <= y + ySize - 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static class slotRegistry
	{
		static int clickedSlot = 0;
		static int tooltip = 0;
		static boolean remove;
		private static void slotControl(int leftCorner, int upperCorner, int x, int y, int pictureSize, int AdamsSlotID, int slotItem)
		{
			//String slotItem = entity.getPersistentData().getString("slot" + AdamsSlotID);
			if (onHexagonButton(leftCorner, upperCorner, x, y, pictureSize) == true)
			{
				if (MouseData.getMouseClick() == 1)
				{
					clickedSlot = AdamsSlotID;
					remove = true;
				}
				else
				{
					remove = false;
				}
				tooltip = AdamsSlotID;
			}
			toTexture.getTexture(slotItem);
		}
		private static int getToolTip()
		{
			return tooltip;
		}
		private static void resetToolTip()
		{
			tooltip = 0;
		}
		private static int getClickedSlot()
		{
			return clickedSlot;
		}
		private static void resetSlotRegistry()
		{
			clickedSlot = 0;
		}
		private static boolean isRemoved()
		{
			return remove;
		}
	}

	

	private static class toTexture
	{
		static boolean isItem;
		
		private static void getTexture(int slotItem)
		{
			String AdamsItemTexture;
			switch (slotItem)
			{
				case 1:
					AdamsItemTexture = "screw";
					break;
				case 2:
					AdamsItemTexture = "spring";
					break;
				default:
					AdamsItemTexture = "missing_texture";
			}
			if (slotItem != 0)
			{
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("gratest_inventions:textures/mycroparts/" + AdamsItemTexture + ".png"));
				isItem = true;
			}
			else
			{
				isItem = false;
			}
			if (grabbedItem != 0)
			{
				//isItem = true;
			}
		}
		private static boolean isItemThere()
		{
			return isItem;
		}
		
	}
}
