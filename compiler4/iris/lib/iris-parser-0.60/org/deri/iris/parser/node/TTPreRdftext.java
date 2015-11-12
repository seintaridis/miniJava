/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class TTPreRdftext extends Token
{
    public TTPreRdftext()
    {
        super.setText("_rdftext");
    }

    public TTPreRdftext(int line, int pos)
    {
        super.setText("_rdftext");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTPreRdftext(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTPreRdftext(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTPreRdftext text.");
    }
}