/*
 * Copyright (C) 2021 obi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package dev.obit.tools.view;

/**
 *
 * @author obi
 */
public enum FontSize {
    
    XSMALL,
    SMALL,
    MEDIUM,
    LARGE,
    XLARGE;
    
    public static String getCssPath(FontSize fontSize){
        switch (fontSize){
            case XSMALL : 
                return "style/fontXSmall.css";
            case SMALL : 
                return "style/fontSmall.css";
            case MEDIUM : 
                return "style/fontMedium.css";
            case LARGE : 
                return "style/fontLarge.css";
            case XLARGE : 
                return "style/fontXLarge.css";
            default : return "style/fontMedium.css";
        }
    }
    
}
