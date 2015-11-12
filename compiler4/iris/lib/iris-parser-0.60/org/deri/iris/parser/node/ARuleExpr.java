/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class ARuleExpr extends PExpr
{
    private PRule _rule_;

    public ARuleExpr()
    {
        // Constructor
    }

    public ARuleExpr(
        @SuppressWarnings("hiding") PRule _rule_)
    {
        // Constructor
        setRule(_rule_);

    }

    @Override
    public Object clone()
    {
        return new ARuleExpr(
            cloneNode(this._rule_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARuleExpr(this);
    }

    public PRule getRule()
    {
        return this._rule_;
    }

    public void setRule(PRule node)
    {
        if(this._rule_ != null)
        {
            this._rule_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rule_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._rule_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._rule_ == child)
        {
            this._rule_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._rule_ == oldChild)
        {
            setRule((PRule) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
