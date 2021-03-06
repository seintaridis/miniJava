/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.parser;

import org.deri.iris.parser.node.*;
import org.deri.iris.parser.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTTDot(@SuppressWarnings("unused") TTDot node)
    {
        this.index = 0;
    }

    @Override
    public void caseTTImpliedby(@SuppressWarnings("unused") TTImpliedby node)
    {
        this.index = 1;
    }

    @Override
    public void caseTTAnd(@SuppressWarnings("unused") TTAnd node)
    {
        this.index = 2;
    }

    @Override
    public void caseTTNot(@SuppressWarnings("unused") TTNot node)
    {
        this.index = 3;
    }

    @Override
    public void caseTTComma(@SuppressWarnings("unused") TTComma node)
    {
        this.index = 4;
    }

    @Override
    public void caseTTLpar(@SuppressWarnings("unused") TTLpar node)
    {
        this.index = 5;
    }

    @Override
    public void caseTTRpar(@SuppressWarnings("unused") TTRpar node)
    {
        this.index = 6;
    }

    @Override
    public void caseTTVariable(@SuppressWarnings("unused") TTVariable node)
    {
        this.index = 7;
    }

    @Override
    public void caseTTQuery(@SuppressWarnings("unused") TTQuery node)
    {
        this.index = 8;
    }

    @Override
    public void caseTTId(@SuppressWarnings("unused") TTId node)
    {
        this.index = 9;
    }

    @Override
    public void caseTTUnders(@SuppressWarnings("unused") TTUnders node)
    {
        this.index = 10;
    }

    @Override
    public void caseTTBinOp(@SuppressWarnings("unused") TTBinOp node)
    {
        this.index = 11;
    }

    @Override
    public void caseTTTerOp(@SuppressWarnings("unused") TTTerOp node)
    {
        this.index = 12;
    }

    @Override
    public void caseTTEq(@SuppressWarnings("unused") TTEq node)
    {
        this.index = 13;
    }

    @Override
    public void caseTTInt(@SuppressWarnings("unused") TTInt node)
    {
        this.index = 14;
    }

    @Override
    public void caseTTPosint(@SuppressWarnings("unused") TTPosint node)
    {
        this.index = 15;
    }

    @Override
    public void caseTTDec(@SuppressWarnings("unused") TTDec node)
    {
        this.index = 16;
    }

    @Override
    public void caseTTStr(@SuppressWarnings("unused") TTStr node)
    {
        this.index = 17;
    }

    @Override
    public void caseTTSq(@SuppressWarnings("unused") TTSq node)
    {
        this.index = 18;
    }

    @Override
    public void caseTTPreInteger(@SuppressWarnings("unused") TTPreInteger node)
    {
        this.index = 19;
    }

    @Override
    public void caseTTPreString(@SuppressWarnings("unused") TTPreString node)
    {
        this.index = 20;
    }

    @Override
    public void caseTTPreDecimal(@SuppressWarnings("unused") TTPreDecimal node)
    {
        this.index = 21;
    }

    @Override
    public void caseTTPreDouble(@SuppressWarnings("unused") TTPreDouble node)
    {
        this.index = 22;
    }

    @Override
    public void caseTTPreFloat(@SuppressWarnings("unused") TTPreFloat node)
    {
        this.index = 23;
    }

    @Override
    public void caseTTPreBase64(@SuppressWarnings("unused") TTPreBase64 node)
    {
        this.index = 24;
    }

    @Override
    public void caseTTPreBoolean(@SuppressWarnings("unused") TTPreBoolean node)
    {
        this.index = 25;
    }

    @Override
    public void caseTTPreDate(@SuppressWarnings("unused") TTPreDate node)
    {
        this.index = 26;
    }

    @Override
    public void caseTTPreDatetime(@SuppressWarnings("unused") TTPreDatetime node)
    {
        this.index = 27;
    }

    @Override
    public void caseTTPreDuration(@SuppressWarnings("unused") TTPreDuration node)
    {
        this.index = 28;
    }

    @Override
    public void caseTTPreYearmonthduration(@SuppressWarnings("unused") TTPreYearmonthduration node)
    {
        this.index = 29;
    }

    @Override
    public void caseTTPreDaytimeduration(@SuppressWarnings("unused") TTPreDaytimeduration node)
    {
        this.index = 30;
    }

    @Override
    public void caseTTPreGday(@SuppressWarnings("unused") TTPreGday node)
    {
        this.index = 31;
    }

    @Override
    public void caseTTPreGmonthday(@SuppressWarnings("unused") TTPreGmonthday node)
    {
        this.index = 32;
    }

    @Override
    public void caseTTPreGmonth(@SuppressWarnings("unused") TTPreGmonth node)
    {
        this.index = 33;
    }

    @Override
    public void caseTTPreGyearmonth(@SuppressWarnings("unused") TTPreGyearmonth node)
    {
        this.index = 34;
    }

    @Override
    public void caseTTPreGyear(@SuppressWarnings("unused") TTPreGyear node)
    {
        this.index = 35;
    }

    @Override
    public void caseTTPreHex(@SuppressWarnings("unused") TTPreHex node)
    {
        this.index = 36;
    }

    @Override
    public void caseTTPreIri(@SuppressWarnings("unused") TTPreIri node)
    {
        this.index = 37;
    }

    @Override
    public void caseTTPreSqname(@SuppressWarnings("unused") TTPreSqname node)
    {
        this.index = 38;
    }

    @Override
    public void caseTTPreTime(@SuppressWarnings("unused") TTPreTime node)
    {
        this.index = 39;
    }

    @Override
    public void caseTTPreXmlliteral(@SuppressWarnings("unused") TTPreXmlliteral node)
    {
        this.index = 40;
    }

    @Override
    public void caseTTPreRdftext(@SuppressWarnings("unused") TTPreRdftext node)
    {
        this.index = 41;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 42;
    }
}
