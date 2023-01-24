package games.windrose.coliseum.dataparser

import games.windrose.coliseum.dataparser.models.Role
import games.windrose.coliseum.dataparser.models.Tag
import org.junit.Assert
import org.junit.Test

class CharacterDataParserImplTest {

    private val dataParser = CharacterDataParserImpl()

    @Test
    fun parseSimpleLine() {
        val line = "13;Riburn Alquin;Bottero;Ewilan;Ewilan!;1;Fantasy;Inconnu;Troll"
        val character = dataParser.parseLine(line) as Role

        Assert.assertEquals(13, character.index)
        Assert.assertEquals(1, character.powerMultiplier)
        Assert.assertEquals("Riburn Alquin", character.name)
        Assert.assertEquals("Bottero", character.author)
        Assert.assertEquals("Ewilan", character.origin)
        Assert.assertEquals("Ewilan!", character.universe)
        Assert.assertTrue(character.tags?.contains(Tag("Fantasy")) == true)
        Assert.assertTrue(character.tags?.contains(Tag("Inconnu")) == true)
        Assert.assertTrue(character.tags?.contains(Tag("Troll")) == true)
    }

    @Test
    fun parseWrongLine() {
        val line = "13;Riburn Alquin;"
        Assert.assertNull(dataParser.parseLine(line))
    }
}
