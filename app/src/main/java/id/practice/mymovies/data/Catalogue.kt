package id.practice.mymovies.data

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Catalogue(
    @SerializedName("movie")
    val movie: List<Movie>,
    @SerializedName("tv")
    val tv: List<TV>
) {
    companion object {
        fun loadData() : Catalogue {
            val jsonString = """
                {
                  "movie" : [
                    {
                      "title" : "Avengers: Infinity War",
                      "description" : "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                      "release_date" : "April, 25 2018",
                      "runtime" : "2h 29m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_avengerinfinity"
                    },
                    {
                      "title" : "Bird Box",
                      "description" : "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.",
                      "release_date" : "December, 13 2018",
                      "runtime" : "2h 4m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_birdbox"
                    },
                    {
                      "title" : "Once Upon a Deadpool",
                      "description" : "A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder & zero F's.",
                      "release_date" : "December 11, 2018",
                      "runtime" : "1h 57m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_deadpool"
                    },
                    {
                      "title" : "Venom",
                      "description" : "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                      "release_date" : "September 28, 2018",
                      "runtime" : "1h 52m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_venom"
                    },
                    {
                      "title" : "Aquaman",
                      "description" : "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                      "release_date" : "December 7, 2018",
                      "runtime" : "2h 24m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_aquaman"
                    },
                    {
                      "title" : "Spider-Man: Into the Spider-Verse",
                      "description" : "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                      "release_date" : "December 6, 2018",
                      "runtime" : "1h 57m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_spiderman"
                    },
                    {
                      "title" : "A Star Is Born",
                      "description" : "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                      "release_date" : "October 3, 2018",
                      "runtime" : "2h 15m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_a_star"
                    },
                    {
                      "title" : "Glass",
                      "description" : "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                      "release_date" : "January 16, 2019",
                      "runtime" : "2h 9m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_glass"
                    },
                    {
                      "title" : "Retired Thug",
                      "description" : "After three years, the business of Muslihat (Epi Kusnandar), who has retired as a thug, has a problem. Sales decline. Muslihat also faces new problems when Safira (Safira Maharani), her only daughter, grows up in adolescence and begins to be visited by boys. A bigger problem: frictions between his former subordinates.",
                      "release_date" : "January 17, 2019",
                      "runtime" : "1h 34m",
                      "original_language" : "Indonesian",
                      "poster" : "@drawable/poster_preman"
                    },
                    {
                      "title" : "Creed II",
                      "description" : "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                      "release_date" : "November 21, 2018",
                      "runtime" : "2h 10m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_creed"
                    }
                  ],
                  "tv" : [
                    {
                      "title" : "Dragon Ball",
                      "description" : "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure.",
                      "release_date" : "February, 26 1986",
                      "runtime" : "25ms",
                      "original_language" : "Japanese",
                      "poster" : "@drawable/poster_dragon_ball"
                    },
                    {
                      "title" : "Naruto Shippūden",
                      "description" : "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                      "release_date" : "February 15, 2007",
                      "runtime" : "22m",
                      "original_language" : "Japanese",
                      "poster" : "@drawable/poster_naruto_shipudden"
                    },
                    {
                      "title" : "Family Guy",
                      "description" : "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for tvShows). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                      "release_date" : "January 31, 1999",
                      "runtime" : "22m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_family_guy"
                    },
                    {
                      "title" : "Supergirl",
                      "description" : "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                      "release_date" : "October 26, 2015",
                      "runtime" : "42m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_supergirl"
                    },
                    {
                      "title" : "The Flash",
                      "description" : "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                      "release_date" : "October 7, 2014",
                      "runtime" : "44m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_flash"
                    },
                    {
                      "title" : "Fairy Tail",
                      "description" : "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                      "release_date" : "October 12, 2009",
                      "runtime" : "25m",
                      "original_language" : "Japanese",
                      "poster" : "@drawable/poster_fairytail"
                    },
                    {
                      "title" : "Shameless",
                      "description" : "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be… perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                      "release_date" : "January 9, 2009",
                      "runtime" : "60m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_shameless"
                    },
                    {
                      "title" : "The Simpson",
                      "description" : "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                      "release_date" : "December 17, 1989",
                      "runtime" : "22m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_the_simpson"
                    },
                    {
                      "title" : "Hanna",
                      "description" : "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                      "release_date" : "March 28, 2019",
                      "runtime" : "50m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_hanna"
                    },
                    {
                      "title" : "Riverdale",
                      "description" : "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale's wholesome facade.",
                      "release_date" : "January 26, 2017",
                      "runtime" : "45m",
                      "original_language" : "English",
                      "poster" : "@drawable/poster_riverdale"
                    }
                  ]
                }
            """.trimIndent()

            return Gson().fromJson(jsonString, Catalogue::class.java)
        }
    }
}