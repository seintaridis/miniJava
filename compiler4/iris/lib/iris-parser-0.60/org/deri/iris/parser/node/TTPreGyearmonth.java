/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class TTPreGyearmonth extends Token
{
    public TTPreGyearmonth()
    {
        super.setText("_gyearmonth");
    }

    public TTPreGyearmonth(int line, int pos)
    {
        super.setText("_gyearmonth");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTPreGyearmonth(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTPreGyearmonth(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTPreGyearmonth text.");
    }
}
