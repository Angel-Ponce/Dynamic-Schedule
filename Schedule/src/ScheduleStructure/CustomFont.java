/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleStructure;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author angelponce
 */
public class CustomFont {

    public static final String VERDANA = "verdana";
    public static final String TIMESNEWROMAN = "timesnewroman";
    public static final String BLACKHIGHLIGHT = "blackhighlight";
    public static final String LETTERS = "letters";
    public static final String JOSEPHSOPHIA = "josephsophia";

    public Font customFont;
    public String fontString;

    public CustomFont(String font) {
        fontString = font;
        switch (font) {
            case VERDANA:
                customFont = new Font("Verdana", Font.PLAIN, 15);
                break;
            case TIMESNEWROMAN:
                customFont = new Font("Times New Roman", Font.PLAIN, 20);
                break;
            case BLACKHIGHLIGHT: {
                try {
                    InputStream is = getClass().getResourceAsStream("/Fonts/BLACK HIGHLIGHT.ttf");
                    customFont = Font.createFont(Font.TRUETYPE_FONT, is);
                    customFont = customFont.deriveFont(20f);
                } catch (FontFormatException | IOException ex) {
                    ex.printStackTrace();
                }
            }
            break;
            case LETTERS: {
                try {
                    InputStream is = getClass().getResourceAsStream("/Fonts/Letters for Learners.ttf");
                    customFont = Font.createFont(Font.TRUETYPE_FONT, is);
                    customFont = customFont.deriveFont(30f);
                } catch (FontFormatException | IOException ex) {
                    ex.printStackTrace();
                }
            }
            break;
            case JOSEPHSOPHIA: {
                try {
                    InputStream is = getClass().getResourceAsStream("/Fonts/josephsophia.ttf");
                    customFont = Font.createFont(Font.TRUETYPE_FONT, is);
                    customFont = customFont.deriveFont(30f);
                } catch (FontFormatException | IOException ex) {
                    ex.printStackTrace();
                }
            }
            break;
            default:
                break;
        }
    }
}
