package com.example.kotlin_examples_datastructures_problems
/*
Given a URL as String, create a function that validates the URL as proper.
The URL should conform to the form PROTOCOL//ADDRESS/VERSION/ENDPOINT.
A valid example would be “https://foo.bar/v1/path”.

All elements must be present in the url.
If an element is missing, its default value must be inserted at the appropriate location.
The default VERSION is “v1”. The default ENDPOINT is “default”.
The default PROTOCOL is “https:”.

Ex:
“http://foo.bar” -> “http://foo.bar/v1/default”
“https://foo.bar/v2” -> “https://foo.bar/v2/default”
“https://test.net/test” -> “https://test.net/v1/test”
“no.dice/endgame/v4” -> “https://no.dice/v4/endgame”
*/
fun validateAndFixUrl(url: String) {
    var correctedUrl: String = ""
    var splittedUrl = url.replace("//", "/").split("/").toMutableList()
    println("splitted url: $splittedUrl")

    correctedUrl = validateProtocol(splittedUrl)
    correctedUrl += validateVersion(splittedUrl)
    correctedUrl += validateEndpoint(splittedUrl)
    println("$url -> $correctedUrl")
}

fun validateProtocol(url: MutableList<String>) : String {
    var correctedUrl = ""
    url.forEach { element ->
        if (!element.lowercase().contains("https:")) {
            if (element.contains(".")) {
                correctedUrl = "https://$element"
            }
        } else {
            correctedUrl = element
            if (element.contains(".")) {
                correctedUrl += element
            }
        }
    }
    return correctedUrl
}

fun validateVersion(url: MutableList<String>) : String {
    url.forEach { element ->
        if (element.lowercase().contains(Regex("v\\d"))) {
            return "/$element"
        }
    }
    return "/v1"
}

fun validateEndpoint(url: MutableList<String>): String {
    url.forEach { element ->
        if (element.lowercase().matches(Regex("^[a-zA-Z ]+$")) &&
            !element.contains("http", ignoreCase = true)) {
            return "/$element"
        }
    }
    return "/default"
}

fun main() {
    val listOfURLs = mutableListOf(
        "http://foo.bar",
        "https://foo.bar/v2",
        "https://test.net/test",
        "no.dice/endgame/v4"
    )
    listOfURLs.forEach { url ->
        validateAndFixUrl(url)
    }
}