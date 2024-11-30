pipeline {
  agent any
    environment {
      // The following variable is required for a Semgrep AppSec Platform-connected scan:
      SEMGREP_APP_TOKEN = credentials('SEMGREP_APP_TOKEN')

      // Uncomment the following line to scan changed
      // files in PRs or MRs (diff-aware scanning):
      // SEMGREP_BASELINE_REF = "main"

      // Troubleshooting:

      // Uncomment the following lines if Semgrep AppSec Platform > Findings Page does not create links
      // to the code that generated a finding or if you are not receiving PR or MR comments.
      // SEMGREP_JOB_URL = "${BUILD_URL}"
      // SEMGREP_COMMIT = "${GIT_COMMIT}"
      // SEMGREP_BRANCH = "${GIT_BRANCH}"
      // SEMGREP_REPO_NAME = env.GIT_URL.replaceFirst(/^https:\/\/github.com\/(.*).git$/, '$1')
      // SEMGREP_REPO_URL = env.GIT_URL.replaceFirst(/^(.*).git$/,'$1')
      // SEMGREP_PR_ID = "${env.CHANGE_ID}"
    }
    stages {
        stage("Build") {
            steps {
                echo 'Building...'
                echo 'Test 2'
                // Si quieres algo más significativo en este paso, puedes agregar el comando para construir el proyecto con Maven
                // ejemplo: sh 'mvn clean install'
            }
        }

          stage('Semgrep-Scan') {
            steps {
              sh 'pip3 install semgrep'
              sh 'semgrep ci'
          }
        
        stage("Test") {
            steps {
                echo 'Running tests...'
                // Aquí podrías agregar comandos de prueba, como: sh 'mvn test'
            }
        }
        
        stage("Deploy") {
            steps {
                echo 'Deploying...'
                // Aquí puedes agregar el comando de despliegue si es necesario, como: sh './deploy.sh'
            }
        }
    }
}
