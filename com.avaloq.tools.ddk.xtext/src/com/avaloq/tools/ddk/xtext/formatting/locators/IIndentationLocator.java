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

/**
 * Interface common to all line indentation locators that are customized and handled by the DDK formatting.
 */
public interface IIndentationLocator extends IDdkLocator {

  /**
   * Sets the indentation of the locator.
   *
   * @return the indentation of this locator
   */
  int getIndentation();

  /**
   * Sets the indentation of this locator.
   *
   * @param indentation
   *          the indentation to set
   */
  void setIndentation(int indentation);
}