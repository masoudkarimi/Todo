# Todo

The Todo project is a sample Android application designed to demonstrate how to create a multi-module application that is modularized by **layer and feature**. The application is built using Kotlin, Coroutines, Flow, Hilt, Jetpack Compose, and Room for Database.

The purpose of the project is to provide an example of how to create a modularized Android application that can be easily maintained and scaled. Each feature and layer is encapsulated in a separate module, making it easy to add or remove functionality without affecting other parts of the application.


## 🛠 Tech Stack & Open Source Libraries

The following technologies are used in this project:
- [Kotlin](https://kotlinlang.org/): A statically-typed programming language for modern multi-platform applications.
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html): A lightweight concurrency framework for asynchronous programming in Kotlin.
- [Flow](https://kotlinlang.org/docs/flow.html): A reactive stream library for asynchronous programming in Kotlin.
- [Hilt](https://dagger.dev/hilt/): A dependency injection framework built on top of Dagger 2 for Android.
- [Jetpack Compose](https://developer.android.com/jetpack/compose): A modern UI toolkit for building native Android UIs.
- [Room](https://developer.android.com/training/data-storage/room): A persistence library that provides an abstraction layer over SQLite for database storage.
- [Version Catalog](https://docs.gradle.org/current/userguide/platforms.html#sub::toml-dependencies-format): Sharing dependency versions between projects

## 🏛️ Architecture

The application is composed of several modules that depend on each other. Here's a diagram that illustrates the dependencies between the modules:

[![](https://mermaid.ink/img/pako:eNqVlFGLozAUhf9KyL5YsKK1ttaBhc62fVtY2HmauizpJO7IaLxohO2W_ve90Vq14wzWQtJ7ck5MPklO9CXjggb0T87glTxtHkgoQ1mUh1o4sELsH7H5FUqCT6GOiahUEsVJEnzZrXf2dmEWKs_eRFM-3JrL-GL3l9-220dy9df1Oz-TPM9iPiZUT2-U8aStL3Hj0uOIkLyzq0jtn1jxVpCdYKrM-5uL1OitRYpnKYvlJWDbu_Vq3a6zrm8S96DA-ZliY_x63pZBnTN00yrVSo26m7QpMp1-vQ5342RqkTiFRKRCqoJYPdsNT9j_yDNcphgmCuOJwt1E4S6iMJoo9IjCO6IwSBQaotAjCh8RhWGifL_BQI8iHw2R88N4fjzFCyApPg9o-80b8ixLx3BEq8EPk2uhcyj81n2j1ksw6q5vHWCGI2EDjAFUuPWpbys8wp0CtPt6VLXU7LmSqw-jRaxg2ARdU_dHCDVpKnIMcbxET1oJqXrF1YY0wL9cRKxMVEhDeUYrK1X28yhfaKDyUpi01DOLTczwq6c0iFhSoCp4rLL8e30xV_ezSYHJZ8TRBLGkwYn-pYHvW_PFcmavXGzmvkmPNHBsz_JmM9v1vZXj-o6_OJv0XxW3raXne0tv7q7mnuvMPOf8H7E25gU?type=png)](https://mermaid.live/edit#pako:eNqVlFGLozAUhf9KyL5YsKK1ttaBhc62fVtY2HmauizpJO7IaLxohO2W_ve90Vq14wzWQtJ7ck5MPklO9CXjggb0T87glTxtHkgoQ1mUh1o4sELsH7H5FUqCT6GOiahUEsVJEnzZrXf2dmEWKs_eRFM-3JrL-GL3l9-220dy9df1Oz-TPM9iPiZUT2-U8aStL3Hj0uOIkLyzq0jtn1jxVpCdYKrM-5uL1OitRYpnKYvlJWDbu_Vq3a6zrm8S96DA-ZliY_x63pZBnTN00yrVSo26m7QpMp1-vQ5342RqkTiFRKRCqoJYPdsNT9j_yDNcphgmCuOJwt1E4S6iMJoo9IjCO6IwSBQaotAjCh8RhWGifL_BQI8iHw2R88N4fjzFCyApPg9o-80b8ixLx3BEq8EPk2uhcyj81n2j1ksw6q5vHWCGI2EDjAFUuPWpbys8wp0CtPt6VLXU7LmSqw-jRaxg2ARdU_dHCDVpKnIMcbxET1oJqXrF1YY0wL9cRKxMVEhDeUYrK1X28yhfaKDyUpi01DOLTczwq6c0iFhSoCp4rLL8e30xV_ezSYHJZ8TRBLGkwYn-pYHvW_PFcmavXGzmvkmPNHBsz_JmM9v1vZXj-o6_OJv0XxW3raXne0tv7q7mnuvMPOf8H7E25gU)

[![](https://mermaid.ink/img/pako:eNpVkE1vwjAMhv9KZC5MqlD6EZpmJxhlh43Tdpp6yYiBammC0lQaQ_z3hbbbmCNFfu3HlvyeYWsVgoC9k8cDeV1Vpu3eB_GMezSqMiRE608axwrZ1VqLyXpN-4ha7-wHiklZlve39KNDNCNM6XpRLMgvO-h_-FJ3ONI8fyjL5R896JHu106frNe1IRurOo3t3dC6rpgujHK2Vjet_orhEQIRNOgaWatw9flaqcAfsMEKREgV7mSnfQWVuQRUdt6-nMwWhHcdRtAdlfS4qmWwqAGxk7oNVVS1t24zONkbGsFRmjdrm5_BIEGc4RME57Nsnie0SMOX8QhOIGLKZixJaMpZEac85vNLBF_9OJ3ljLOcZWmRsTRO2OUbQEqGiQ?type=png)](https://mermaid.live/edit#pako:eNpVkE1vwjAMhv9KZC5MqlD6EZpmJxhlh43Tdpp6yYiBammC0lQaQ_z3hbbbmCNFfu3HlvyeYWsVgoC9k8cDeV1Vpu3eB_GMezSqMiRE608axwrZ1VqLyXpN-4ha7-wHiklZlve39KNDNCNM6XpRLMgvO-h_-FJ3ONI8fyjL5R896JHu106frNe1IRurOo3t3dC6rpgujHK2Vjet_orhEQIRNOgaWatw9flaqcAfsMEKREgV7mSnfQWVuQRUdt6-nMwWhHcdRtAdlfS4qmWwqAGxk7oNVVS1t24zONkbGsFRmjdrm5_BIEGc4RME57Nsnie0SMOX8QhOIGLKZixJaMpZEac85vNLBF_9OJ3ljLOcZWmRsTRO2OUbQEqGiQ)

## 🤝Contributing

Most of the features are not completed yet, so anyone can contribute and improve this project following the [Contributing Guideline](https://github.com/skydoves/chatgpt-android/blob/main/CONTRIBUTING.md).
