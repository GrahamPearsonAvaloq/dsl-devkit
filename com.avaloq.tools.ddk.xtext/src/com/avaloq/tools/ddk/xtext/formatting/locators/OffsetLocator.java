/*******************************************************************************
 * Copyright (c) 2016 Avaloq Evolution AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Avaloq Evolution AG - initial API and implementation
 *******************************************************************************/
package com.avaloq.tools.ddk.xtext.formatting.locators;

import org.eclipse.xtext.formatting.impl.AbstractFormattingConfig.ElementLocator;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

import com.avaloq.tools.ddk.xtext.formatting.DdkLine;
import com.avaloq.tools.ddk.xtext.formatting.DdkLineEntry;
import com.avaloq.tools.ddk.xtext.formatting.SpaceEntry;


/**
 * Offset locator with offset padding. The OffsetLocator is similar to the ColumnLocator - the difference
 * is that the value/offset specified is relative to the indentation, not the beginning of the line.
 * The method {@link #getPadding(InternalDdkLine, DdkLineEntry)} will calculate the
 * necessary amount of padding required.
 */
public class OffsetLocator extends ElementLocator implements ISpaceLocator {
  private final int offset;

  /**
   * Creates a new offset locator.
   *
   * @param offset
   *          the offset
   */
  public OffsetLocator(final FormattingConfig formattingConfig, final int offset) { // NOPMD CallSuperInConstructor - false positive by PMD
    formattingConfig.super();
    this.offset = offset;
  }

  /**
   * Gets the padding for an entry. When the padding is prepended to the value of the entry,
   * the entry will be at the character position specified in the constructor.
   *
   * @param line
   *          the line containing entry / to which entry is to be added
   * @param entry
   *          the entry to be padded
   * @return the padding required to ensure entry will occupy space after the specified offset
   */
  @Override
  public String computeSpace(final DdkLine line, final DdkLineEntry entry) {
    int length = offset - line.getOffset(entry);
    if (length < 1 && offset > 0) {
      // unless offset is 0 always create at least one character of padding
      length = 1;
    }
    return SpaceEntry.createPadding(length);
  }

  /** {@inheritDoc} */
  @Override
  public AggregationPolicy getPolicy() {
    return AggregationPolicy.COMBINED_MAXIMUM;
  }
}