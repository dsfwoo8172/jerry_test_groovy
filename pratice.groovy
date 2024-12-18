job('pratice-via-DSL') {
    steps {
        shell('echo "Hello, World!"')
    }

    scm {
        git("https://github.com/dsfwoo8172/rent_house.git", "main")
    }

    triggers {
        scm('* * * * *')
    }
}

// job('robot-notification') {
//     description('')
//     keepDependencies(false)
//     configure { project ->
//         project / 'properties' / 'io.jenkins.plugins.DingTalkJobProperty' {
//             notifierConfigs {
//                 'io.jenkins.plugins.DingTalkNotifierConfig' {
//                     raw(false)
//                     disabled(false)
//                     checked(true)
//                     robotId('4d1055b4-43e9-4536-b445-aa0b80d62c44')
//                     robotName('浪Live小幫手(測試)@機器人')
//                     atAll(false)
//                     atMobile('')
//                     content('executed the deployment of a ${PROJECT_NAME} project. (TEST MESSAGE)\n\nURL: ${JOB_URL}')
//                     message('')
//                     noticeOccasions {
//                         string('SUCCESS')
//                         string('FAILURE')
//                     }
//                 }
//             }
//         }
//     }
//     scm {
//         // No SCM configured
//     }
//     disabled(false)
//     blockBuildWhenDownstreamBuilding(false)
//     blockBuildWhenUpstreamBuilding(false)
//     triggers {
//         // No triggers configured
//     }
//     concurrentBuild(false)
//     steps {
//         shell('echo \'Testing...\'')
//         shell('echo ${BUILD_NUMBER}')
//     }
//     publishers {
//         // No publishers configured
//     }
//     buildWrappers {
//         // No build wrappers configured
//     }
// }

job('robot-notification') {
    description('')
    keepDependencies(false)
    configure { project ->
        project / 'properties' / 'io.jenkins.plugins.DingTalkJobProperty' {
            notifierConfigs {
                'io.jenkins.plugins.DingTalkNotifierConfig' {
                    raw(false)
                    disabled(false)
                    checked(true)
                    robotId('4d1055b4-43e9-4536-b445-aa0b80d62c44')
                    robotName('浪Live小幫手(測試)@機器人')
                    atAll(false)
                    atMobile('')
                    content('executed the deployment of a ${PROJECT_NAME} project. (TEST MESSAGE)\n\nURL: ${JOB_URL}')
                    message('')
                    noticeOccasions {
                        string('SUCCESS')
                        string('FAILURE')
                    }
                }
            }
        }
    }
    scm {
        // No SCM configured
    }
    disabled(false)
    triggers {
        // No triggers configured
    }
    concurrentBuild(false)
    steps {
        shell('echo \'Testing...\'')
        shell('echo ${BUILD_NUMBER}')
    }
    publishers {
        // No publishers configured
    }
    wrappers {
        // No wrappers configured
    }
}