/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class ATermlist extends PTermlist
{
    private PTermlist _termlist_;
    private TTComma _tComma_;
    private PTerm _term_;

    public ATermlist()
    {
        // Constructor
    }

    public ATermlist(
        @SuppressWarnings("hiding") PTermlist _termlist_,
        @SuppressWarnings("hiding") TTComma _tComma_,
        @SuppressWarnings("hiding") PTerm _term_)
    {
        // Constructor
        setTermlist(_termlist_);

        setTComma(_tComma_);

        setTerm(_term_);

    }

    @Override
    public Object clone()
    {
        return new ATermlist(
            cloneNode(this._termlist_),
            cloneNode(this._tComma_),
            cloneNode(this._term_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATermlist(this);
    }

    public PTermlist getTermlist()
    {
        return this._termlist_;
    }

    public void setTermlist(PTermlist node)
    {
        if(this._termlist_ != null)
        {
            this._termlist_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._termlist_ = node;
    }

    public TTComma getTComma()
    {
        return this._tComma_;
    }

    public void setTComma(TTComma node)
    {
        if(this._tComma_ != null)
        {
            this._tComma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tComma_ = node;
    }

    public PTerm getTerm()
    {
        return this._term_;
    }

    public void setTerm(PTerm node)
    {
        if(this._term_ != null)
        {
            this._term_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._term_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._termlist_)
            + toString(this._tComma_)
            + toString(this._term_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._termlist_ == child)
        {
            this._termlist_ = null;
            return;
        }

        if(this._tComma_ == child)
        {
            this._tComma_ = null;
            return;
        }

        if(this._term_ == child)
        {
            this._term_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._termlist_ == oldChild)
        {
            setTermlist((PTermlist) newChild);
            return;
        }

        if(this._tComma_ == oldChild)
        {
            setTComma((TTComma) newChild);
            return;
        }

        if(this._term_ == oldChild)
        {
            setTerm((PTerm) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
