/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class TTPreDate extends Token
{
    public TTPreDate()
    {
        super.setText("_date");
    }

    public TTPreDate(int line, int pos)
    {
        super.setText("_date");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTPreDate(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTPreDate(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTPreDate text.");
    }
}
