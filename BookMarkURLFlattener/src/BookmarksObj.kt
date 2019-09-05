import com.google.gson.JsonArray
import com.google.gson.JsonNull
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import java.io.File
import java.io.FileReader
import java.util.*
import javax.swing.JFrame

/**
 * This represents a simple bookmarks parser.
 */
fun main(args: Array<String>) {
    var file: String = ""
    if (args[0].equals("-b")) {
        file = args[1]
    }
    else {
        println("need a valid Bookmarks file to parse.")
        System.exit(1)
    }
    println(getUrls(file))
    //println(getUrlsInFolder(file, "old cs pages"))
}

fun getUrls(file: String) : List<String> {
    val json = JsonParser().parse(JsonReader(FileReader(File(file)))).asJsonObject;
    val bookmark_bar = json.get("roots").asJsonObject.get("bookmark_bar").asJsonObject

    val bookmarks = bookmark_bar.get("children").asJsonArray
    val urls: ArrayList<String> = ArrayList<String>()
    getUrls(bookmarks, urls)
    return urls
}

//fun getUrlsInFolder(file: String, folderName: String) : List<String> {
//    val json = JsonParser().parse(JsonReader(FileReader(File(file)))).asJsonObject;
//    val bookmark_bar = json.get("roots").asJsonObject.get("bookmark_bar").asJsonObject
//    val bookmarks = bookmark_bar.get("children").asJsonArray
//    val urls: ArrayList<String> = ArrayList<String>()
//    val folder = findFolder(bookmarks, folderName)
//    getUrls(folder.asJsonArray, urls)
//    return urls
//}

private fun getUrls(subfolder: JsonArray, list: ArrayList<String>) {
    for (entry in subfolder) {
        if (entry.asJsonObject.has("children")) {
            getUrls(entry.asJsonObject.get("children").asJsonArray, list)
        }
        else {
            list.add(entry.asJsonObject.get("url").asString)
        }
    }
}

//fun findFolder(currentfolder: JsonArray, folderName: String) : JsonObject {
//    if (currentfolder.get("type").asString.equals("folder")) {
//        if (currentfolder.asJsonObject.get("name").asString.equals(folderName)) {
//            return currentfolder.asJsonObject
//        }
//    }
//    else {
//        for (element in currentfolder.asJsonArray) {
//            if (element.asJsonObject.has("children")) {
//                findFolder(element.asJsonObject.get("children").asJsonArray, folderName)
//            }
//        }
//    }
//    throw IllegalArgumentException("No such folder!")
//}

