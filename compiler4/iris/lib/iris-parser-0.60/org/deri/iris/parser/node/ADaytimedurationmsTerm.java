/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class ADaytimedurationmsTerm extends PTerm
{
    private TTPreDaytimeduration _tPreDaytimeduration_;
    private TTLpar _tLpar_;
    private TTInt _day_;
    private TTComma _tComma_;
    private TTInt _hour_;
    private TTComma _c2_;
    private TTInt _minute_;
    private TTComma _c3_;
    private TTInt _second_;
    private TTComma _c4_;
    private TTInt _millisecond_;
    private TTRpar _tRpar_;

    public ADaytimedurationmsTerm()
    {
        // Constructor
    }

    public ADaytimedurationmsTerm(
        @SuppressWarnings("hiding") TTPreDaytimeduration _tPreDaytimeduration_,
        @SuppressWarnings("hiding") TTLpar _tLpar_,
        @SuppressWarnings("hiding") TTInt _day_,
        @SuppressWarnings("hiding") TTComma _tComma_,
        @SuppressWarnings("hiding") TTInt _hour_,
        @SuppressWarnings("hiding") TTComma _c2_,
        @SuppressWarnings("hiding") TTInt _minute_,
        @SuppressWarnings("hiding") TTComma _c3_,
        @SuppressWarnings("hiding") TTInt _second_,
        @SuppressWarnings("hiding") TTComma _c4_,
        @SuppressWarnings("hiding") TTInt _millisecond_,
        @SuppressWarnings("hiding") TTRpar _tRpar_)
    {
        // Constructor
        setTPreDaytimeduration(_tPreDaytimeduration_);

        setTLpar(_tLpar_);

        setDay(_day_);

        setTComma(_tComma_);

        setHour(_hour_);

        setC2(_c2_);

        setMinute(_minute_);

        setC3(_c3_);

        setSecond(_second_);

        setC4(_c4_);

        setMillisecond(_millisecond_);

        setTRpar(_tRpar_);

    }

    @Override
    public Object clone()
    {
        return new ADaytimedurationmsTerm(
            cloneNode(this._tPreDaytimeduration_),
            cloneNode(this._tLpar_),
            cloneNode(this._day_),
            cloneNode(this._tComma_),
            cloneNode(this._hour_),
            cloneNode(this._c2_),
            cloneNode(this._minute_),
            cloneNode(this._c3_),
            cloneNode(this._second_),
            cloneNode(this._c4_),
            cloneNode(this._millisecond_),
            cloneNode(this._tRpar_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADaytimedurationmsTerm(this);
    }

    public TTPreDaytimeduration getTPreDaytimeduration()
    {
        return this._tPreDaytimeduration_;
    }

    public void setTPreDaytimeduration(TTPreDaytimeduration node)
    {
        if(this._tPreDaytimeduration_ != null)
        {
            this._tPreDaytimeduration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tPreDaytimeduration_ = node;
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

    public TTInt getDay()
    {
        return this._day_;
    }

    public void setDay(TTInt node)
    {
        if(this._day_ != null)
        {
            this._day_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._day_ = node;
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

    public TTInt getHour()
    {
        return this._hour_;
    }

    public void setHour(TTInt node)
    {
        if(this._hour_ != null)
        {
            this._hour_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._hour_ = node;
    }

    public TTComma getC2()
    {
        return this._c2_;
    }

    public void setC2(TTComma node)
    {
        if(this._c2_ != null)
        {
            this._c2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._c2_ = node;
    }

    public TTInt getMinute()
    {
        return this._minute_;
    }

    public void setMinute(TTInt node)
    {
        if(this._minute_ != null)
        {
            this._minute_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minute_ = node;
    }

    public TTComma getC3()
    {
        return this._c3_;
    }

    public void setC3(TTComma node)
    {
        if(this._c3_ != null)
        {
            this._c3_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._c3_ = node;
    }

    public TTInt getSecond()
    {
        return this._second_;
    }

    public void setSecond(TTInt node)
    {
        if(this._second_ != null)
        {
            this._second_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._second_ = node;
    }

    public TTComma getC4()
    {
        return this._c4_;
    }

    public void setC4(TTComma node)
    {
        if(this._c4_ != null)
        {
            this._c4_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._c4_ = node;
    }

    public TTInt getMillisecond()
    {
        return this._millisecond_;
    }

    public void setMillisecond(TTInt node)
    {
        if(this._millisecond_ != null)
        {
            this._millisecond_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._millisecond_ = node;
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
            + toString(this._tPreDaytimeduration_)
            + toString(this._tLpar_)
            + toString(this._day_)
            + toString(this._tComma_)
            + toString(this._hour_)
            + toString(this._c2_)
            + toString(this._minute_)
            + toString(this._c3_)
            + toString(this._second_)
            + toString(this._c4_)
            + toString(this._millisecond_)
            + toString(this._tRpar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tPreDaytimeduration_ == child)
        {
            this._tPreDaytimeduration_ = null;
            return;
        }

        if(this._tLpar_ == child)
        {
            this._tLpar_ = null;
            return;
        }

        if(this._day_ == child)
        {
            this._day_ = null;
            return;
        }

        if(this._tComma_ == child)
        {
            this._tComma_ = null;
            return;
        }

        if(this._hour_ == child)
        {
            this._hour_ = null;
            return;
        }

        if(this._c2_ == child)
        {
            this._c2_ = null;
            return;
        }

        if(this._minute_ == child)
        {
            this._minute_ = null;
            return;
        }

        if(this._c3_ == child)
        {
            this._c3_ = null;
            return;
        }

        if(this._second_ == child)
        {
            this._second_ = null;
            return;
        }

        if(this._c4_ == child)
        {
            this._c4_ = null;
            return;
        }

        if(this._millisecond_ == child)
        {
            this._millisecond_ = null;
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
        if(this._tPreDaytimeduration_ == oldChild)
        {
            setTPreDaytimeduration((TTPreDaytimeduration) newChild);
            return;
        }

        if(this._tLpar_ == oldChild)
        {
            setTLpar((TTLpar) newChild);
            return;
        }

        if(this._day_ == oldChild)
        {
            setDay((TTInt) newChild);
            return;
        }

        if(this._tComma_ == oldChild)
        {
            setTComma((TTComma) newChild);
            return;
        }

        if(this._hour_ == oldChild)
        {
            setHour((TTInt) newChild);
            return;
        }

        if(this._c2_ == oldChild)
        {
            setC2((TTComma) newChild);
            return;
        }

        if(this._minute_ == oldChild)
        {
            setMinute((TTInt) newChild);
            return;
        }

        if(this._c3_ == oldChild)
        {
            setC3((TTComma) newChild);
            return;
        }

        if(this._second_ == oldChild)
        {
            setSecond((TTInt) newChild);
            return;
        }

        if(this._c4_ == oldChild)
        {
            setC4((TTComma) newChild);
            return;
        }

        if(this._millisecond_ == oldChild)
        {
            setMillisecond((TTInt) newChild);
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
