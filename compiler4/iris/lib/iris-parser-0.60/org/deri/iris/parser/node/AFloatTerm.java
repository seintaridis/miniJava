/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class AFloatTerm extends PTerm
{
    private TTPreFloat _tPreFloat_;
    private TTLpar _tLpar_;
    private TTDec _tDec_;
    private TTRpar _tRpar_;

    public AFloatTerm()
    {
        // Constructor
    }

    public AFloatTerm(
        @SuppressWarnings("hiding") TTPreFloat _tPreFloat_,
        @SuppressWarnings("hiding") TTLpar _tLpar_,
        @SuppressWarnings("hiding") TTDec _tDec_,
        @SuppressWarnings("hiding") TTRpar _tRpar_)
    {
        // Constructor
        setTPreFloat(_tPreFloat_);

        setTLpar(_tLpar_);

        setTDec(_tDec_);

        setTRpar(_tRpar_);

    }

    @Override
    public Object clone()
    {
        return new AFloatTerm(
            cloneNode(this._tPreFloat_),
            cloneNode(this._tLpar_),
            cloneNode(this._tDec_),
            cloneNode(this._tRpar_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFloatTerm(this);
    }

    public TTPreFloat getTPreFloat()
    {
        return this._tPreFloat_;
    }

    public void setTPreFloat(TTPreFloat node)
    {
        if(this._tPreFloat_ != null)
        {
            this._tPreFloat_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tPreFloat_ = node;
    }

    public TTLpar getTLpar()
    {
        return this._tLpar_;
    }

    public void setTLpar(TTLpar node)
    {
        if(this._tLpar_ != null)
        {
            this._tLpar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tLpar_ = node;
    }

    public TTDec getTDec()
    {
        return this._tDec_;
    }

    public void setTDec(TTDec node)
    {
        if(this._tDec_ != null)
        {
            this._tDec_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tDec_ = node;
    }

    public TTRpar getTRpar()
    {
        return this._tRpar_;
    }

    public void setTRpar(TTRpar node)
    {
        if(this._tRpar_ != null)
        {
            this._tRpar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tRpar_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tPreFloat_)
            + toString(this._tLpar_)
            + toString(this._tDec_)
            + toString(this._tRpar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tPreFloat_ == child)
        {
            this._tPreFloat_ = null;
            return;
        }

        if(this._tLpar_ == child)
        {
            this._tLpar_ = null;
            return;
        }

        if(this._tDec_ == child)
        {
            this._tDec_ = null;
            return;
        }

        if(this._tRpar_ == child)
        {
            this._tRpar_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tPreFloat_ == oldChild)
        {
            setTPreFloat((TTPreFloat) newChild);
            return;
        }

        if(this._tLpar_ == oldChild)
        {
            setTLpar((TTLpar) newChild);
            return;
        }

        if(this._tDec_ == oldChild)
        {
            setTDec((TTDec) newChild);
            return;
        }

        if(this._tRpar_ == oldChild)
        {
            setTRpar((TTRpar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
