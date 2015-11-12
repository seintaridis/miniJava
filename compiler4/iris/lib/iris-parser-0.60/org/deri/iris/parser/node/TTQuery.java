/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class TTQuery extends Token
{
    public TTQuery()
    {
        super.setText("?-");
    }

    public TTQuery(int line, int pos)
    {
        super.setText("?-");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTQuery(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTQuery(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTQuery text.");
    }
}
