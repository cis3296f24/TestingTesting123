package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun getanItem(){
        val item1 = Item("item1")
     collection.addItem((Item("item1")))
        collection.addItem((Item("item2")))
        val item = collection.get(0)
       assert(item==item1) {
           "Get Does Not Fetch Correct Items"
       }

    }

    @Test
    fun removeandItem(){
        val item1 = Item("item1")
        collection.addItem((Item("item1")))
        collection.addItem((Item("item2")))
        val Removed = collection.remove(Item("item1"))
        val item = collection.get(0)
        val sizeAfterRemoval = collection.size()
        assert( item1 != item && sizeAfterRemoval == 1) { "item1 should be removed and size should be 1, got removed = $Removed, size = $sizeAfterRemoval" }
        assert(!collection.remove(Item("item1"))) { "Removing 'item1' again should fail" }
    }
}

private operator fun Unit.not(): Boolean {
    return false

}
