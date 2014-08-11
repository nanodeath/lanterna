/*
 * This file is part of lanterna (http://code.google.com/p/lanterna/).
 *
 * lanterna is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2010-2014 Martin
 */
package com.googlecode.lanterna.gui2;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.*;
import com.googlecode.lanterna.screen.TabBehaviour;

import java.util.EnumSet;

/**
 * @author Martin
 */
public class TextGUIGraphics implements ThemedTextGraphics {
    private final TextGraphics backend;
    private final Theme theme;

    TextGUIGraphics(TextGraphics backend, Theme theme) {
        this.backend = backend;
        this.theme = theme;
    }

    TextGUIGraphics withTheme(Theme theme) {
        return new TextGUIGraphics(backend, theme);
    }

    @Override
    public ThemeDefinition getThemeDefinition(Class clazz) {
        return theme.getDefinition(clazz);
    }

    @Override
    public TextGUIGraphics applyThemeStyle(ThemeStyle themeStyle) {
        setForegroundColor(themeStyle.getForeground());
        setBackgroundColor(themeStyle.getBackground());
        setModifiers(themeStyle.getSGRs());
        return this;
    }

    @Override
    public TerminalSize getSize() {
        return backend.getSize();
    }

    @Override
    public TextGUIGraphics newTextGraphics(TerminalPosition topLeftCorner, TerminalSize size) throws IllegalArgumentException {
        backend.newTextGraphics(topLeftCorner, size);
        return this;
    }

    @Override
    public TextGUIGraphics setPosition(int column, int row) {
        backend.setPosition(column, row);
        return this;
    }

    @Override
    public TextGUIGraphics setPosition(TerminalPosition newPosition) {
        backend.setPosition(newPosition);
        return this;
    }

    @Override
    public TextGUIGraphics movePosition(int columns, int rows) {
        backend.movePosition(columns, rows);
        return this;
    }

    @Override
    public TerminalPosition getPosition() {
        return backend.getPosition();
    }

    @Override
    public TextColor getBackgroundColor() {
        return backend.getBackgroundColor();
    }

    @Override
    public TextGUIGraphics setBackgroundColor(TextColor backgroundColor) {
        backend.setBackgroundColor(backgroundColor);
        return this;
    }

    @Override
    public TextColor getForegroundColor() {
        return backend.getForegroundColor();
    }

    @Override
    public TextGUIGraphics setForegroundColor(TextColor foregroundColor) {
        backend.setForegroundColor(foregroundColor);
        return this;
    }

    @Override
    public TextGUIGraphics enableModifiers(SGR... modifiers) {
        backend.enableModifiers(modifiers);
        return this;
    }

    @Override
    public TextGUIGraphics disableModifiers(SGR... modifiers) {
        backend.disableModifiers(modifiers);
        return this;
    }

    @Override
    public TextGUIGraphics setModifiers(EnumSet<SGR> modifiers) {
        backend.setModifiers(modifiers);
        return this;
    }

    @Override
    public TextGUIGraphics clearModifiers() {
        backend.clearModifiers();
        return this;
    }

    @Override
    public EnumSet<SGR> getActiveModifiers() {
        return backend.getActiveModifiers();
    }

    @Override
    public TabBehaviour getTabBehaviour() {
        return backend.getTabBehaviour();
    }

    @Override
    public TextGUIGraphics setTabBehaviour(TabBehaviour tabBehaviour) {
        backend.setTabBehaviour(tabBehaviour);
        return this;
    }

    @Override
    public TextGUIGraphics fillScreen(char c) {
        backend.fillScreen(c);
        return this;
    }

    @Override
    public TextGUIGraphics setCharacter(char character) {
        backend.setCharacter(character);
        return this;
    }

    @Override
    public TextGUIGraphics drawLine(TerminalPosition toPoint, char character) {
        backend.drawLine(toPoint, character);
        return this;
    }

    @Override
    public TextGUIGraphics drawTriangle(TerminalPosition p1, TerminalPosition p2, char character) {
        backend.drawTriangle(p1, p2, character);
        return this;
    }

    @Override
    public TextGUIGraphics fillTriangle(TerminalPosition p1, TerminalPosition p2, char character) {
        backend.fillTriangle(p1, p2, character);
        return this;
    }

    @Override
    public TextGUIGraphics drawRectangle(TerminalSize size, char character) {
        backend.drawRectangle(size, character);
        return this;
    }

    @Override
    public TextGUIGraphics fillRectangle(TerminalSize size, char character) {
        backend.fillRectangle(size, character);
        return this;
    }

    @Override
    public TextGUIGraphics putString(String string) {
        backend.putString(string);
        return this;
    }

    @Override
    public TextGUIGraphics putString(int column, int row, String string) {
        backend.putString(column, row, string);
        return this;
    }

    @Override
    public TextGUIGraphics putString(TerminalPosition position, String string) {
        backend.putString(position, string);
        return this;
    }

    @Override
    public TextGUIGraphics putString(int column, int row, String string, SGR extraModifier, SGR... optionalExtraModifiers) {
        backend.putString(column, row, string, extraModifier, optionalExtraModifiers);
        return this;
    }

    @Override
    public TextGUIGraphics putString(TerminalPosition position, String string, SGR extraModifier, SGR... optionalExtraModifiers) {
        backend.putString(position, string, extraModifier, optionalExtraModifiers);
        return this;
    }

    @Override
    public TextGUIGraphics putString(String string, SGR extraModifier, SGR... optionalExtraModifiers) {
        backend.putString(string, extraModifier, optionalExtraModifiers);
        return this;
    }
}