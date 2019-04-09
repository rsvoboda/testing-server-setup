import jenkins.model.*
import hudson.model.*
import hudson.tasks.*
import hudson.tools.*

def inst = Jenkins.getInstance()

def desc = inst.getDescriptor("hudson.tasks.Maven")

def versions = [
  "maven-3.5.4": "/var/lib/jenkins/.sdkman/candidates/maven/3.5.4",
  "maven-3.6.0": "/var/lib/jenkins/.sdkman/candidates/maven/3.6.0",
]
def installations = [];

for (v in versions) {
  def installation = new Maven.MavenInstallation(v.key, v.value)
  installations.push(installation)
}

desc.setInstallations(installations.toArray(new Maven.MavenInstallation[0]))
desc.save()