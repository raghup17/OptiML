package org.scalatest.tools
import java.awt.Component
import javax.swing._
private[tools] trait EventHolderListCellRenderer extends ListCellRenderer {
  private val defaultRenderer: DefaultListCellRenderer = new DefaultListCellRenderer()
  protected def decorate(renderer: JLabel, value: Object, isSelected: Boolean): Component
  def getListCellRendererComponent(list: JList, value: Object, index: Int, isSelected: Boolean, cellHasFocus: Boolean): Component = {
    val renderer: JLabel = defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus).asInstanceOf[JLabel]
    decorate(renderer, value, isSelected)
  }}
