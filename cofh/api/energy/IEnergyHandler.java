package cofh.api.energy;

import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergyHandler extends IEnergyProvider, IEnergyReceiver {
   int receiveEnergy(ForgeDirection var1, int var2, boolean var3);

   int extractEnergy(ForgeDirection var1, int var2, boolean var3);

   int getEnergyStored(ForgeDirection var1);

   int getMaxEnergyStored(ForgeDirection var1);
}
